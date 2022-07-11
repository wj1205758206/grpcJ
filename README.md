# grpcJ

grpcJ使用gRPC实现微服务模块之间RPC通信，提高上下游模块之间流量转发性能，zookeeper作为服务注册发现中心，实现gRPC Server端的注册功能，以及gRPC Client端的服务发现和负载均衡。使用kafka作为消息队列，实现上游模块实时的流量转发到下游模块。基于common-pool2实现了gRPC客户端连接池，提高吞吐量。为了更好的控制上游模块流量转发的速率，使用redis中间件实现限流器。

# grpcJ整体架构设计

![image](https://user-images.githubusercontent.com/52147760/178232015-53967f17-d4e7-4480-beb4-85ba537a5ae3.png)


# 服务注册与发现

### Server端

gRPC server启动成功之后，会调用`register()`方法，将ip地址、端口号、时间戳等相关信息拼接成一个字符串，作为zookeeper的一个节点，统一注册到`/grpc_services`这个路径下，`/grpc_services`这个路径下面挂载了当前所有可用的服务节点。

### Client端

基于不同key从Grpc Client连接池中取出一个Grpc Client，用于RPC通信。Grpc Client通过自定义实现的`zkNameResolver`类获取`/grpc_services`这个路径下所有可用的服务节点信息，同时将这些节点信息包装成一个个的`SocketAddress`，放到`EquivalentAddressGroup`地址列表中，也是说这个地址列表维护了所有服务节点的信息和地址。同时调用`zkNameResolver`的`listener`监听器的`onAddress()`方法实时监听地址列表信息。LB会根据设置的负载均衡策略，从服务地址列表里面选择一个目标节点，进行后续的RPC通信。

`round_robin`策略从解析器获取地址列表。它为每个地址创建一个子通道，并持续监控子通道的连接状态。每当子通道断开连接时，`round_robin`策略将要求它重新连接，并使用适当的连接退避。当在通道上发送 RPC 时，`round_robin`策略将遍历当前处于 READY 状态的所有子通道，并将其它RPC轮询到下一个子通道发送，相当于将大量的RPC请求平均分散到每个gRPC Server上。

# 流量转发

使用kafka消息队列实现流量数据的分发，上游模块A相当于kafka的生产者，下游模块B相当于kafka的消费者。

上游模块A计算出key(根据业务计算出的hash值)，按照不同key将数据分发到kafka的不同topic下的不同partition。

下游模块B根据自己的职责，监听并消费不同topic下的不同partition的消息。

由于gRPC使用protocol buffer定义服务并实现通信数据的压缩，所以自定义实现了PB二进制序列化和反序列化器，将上游模块A发送来的数据进行序列化，然后再推送到kafka消息队列中，下游模块B监听到消息时，需要做反序列化处理。通过自定义的PB字节流序列化和反序列化，提高了流量转发的带宽，提升了模块之间数据吞吐量。

# Grpc Client连接池

由于上游模块转发的流量比较大，虽然gRPC底层使用http2，而http2是支持多路复用的，按理来说不需要额外的连接池，但是经过压测单个gRPC Client连接数有限，并发量过大，会导致CPU飙升，吞吐量下降，所以需要将gRPC Client池化，使用客户端连接池来提高吞吐量。基于common-pool2实现的gRPC客户端连接池，使用GenericKeyedObjectPool类来实现带key的gRPC Client连接池。

连接池详细介绍可以看`grpc-java-pool`   github地址https://github.com/wj1205758206/grpc-java-pool

# 流量控制

Grpc Server可能出现故障或者出现网络堵塞等问题，我们还需要在Grpc Client与Grpc Server进行RPC通信时，添加一个请求拦截器，基于实际情况进行流量控制。本项目基于redis和redisson实现分布式限流器，限流器的详细介绍可以看`RRLimiter` github地址https://github.com/wj1205758206/RRLimiter

