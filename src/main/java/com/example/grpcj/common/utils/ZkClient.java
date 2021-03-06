package com.example.grpcj.common.utils;

import com.example.grpcj.common.configuration.ZkConfig;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.framework.state.ConnectionStateListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class ZkClient {
    private static final Logger logger = LoggerFactory.getLogger(ZkClient.class);

    private CuratorFramework zkClient;
    @Resource
    private ZkConfig zkConfig;

    @PostConstruct
    public void init() {
        try {
            RetryPolicy retryPolicy = new ExponentialBackoffRetry
                    (zkConfig.getBaseSleepTimeMs(), zkConfig.getMaxRetries());
            CuratorFrameworkFactory.Builder builder = CuratorFrameworkFactory.builder();
            builder.connectString(zkConfig.getServer())
                    .retryPolicy(retryPolicy)
                    .sessionTimeoutMs(zkConfig.getSessionTimeoutMs())
                    .connectionTimeoutMs(zkConfig.getConnectionTimeoutMs())
                    .namespace(zkConfig.getNamespace());
//            if (StringUtil.isNullOrEmpty(zkConfig.getDigest())) {
//                builder.authorization("digest", zkConfig.getDigest().getBytes(StandardCharsets.UTF_8));
//                builder.aclProvider(new ACLProvider() {
//                    @Override
//                    public List<ACL> getDefaultAcl() {
//                        return ZooDefs.Ids.CREATOR_ALL_ACL;
//                    }
//
//                    @Override
//                    public List<ACL> getAclForPath(String s) {
//                        return ZooDefs.Ids.CREATOR_ALL_ACL;
//                    }
//                });
//            }
            zkClient = builder.build();
            zkClient.start();

            zkClient.getConnectionStateListenable().addListener(new ConnectionStateListener() {
                @Override
                public void stateChanged(CuratorFramework curatorFramework, ConnectionState connectionState) {
                    if (connectionState == ConnectionState.LOST) {
                        logger.info("[zkClient]: lost session with zookeeper...");
                    } else if (connectionState == ConnectionState.CONNECTED) {
                        logger.info("[zkClient]: connected with zookeeper...");
                    } else if (connectionState == ConnectionState.RECONNECTED) {
                        logger.info("[zkClient]: reconnected with zookeeper...");
                    }
                }
            });
        } catch (Exception e) {
            logger.error("[zkClient]: init exception:{}", e);
        }
    }

    /**
     * ?????????????????????
     *
     * @param path
     * @param data
     * @return
     */
    public boolean createPersistentNode(String path, String data) {
        try {
            zkClient.create()
                    .creatingParentsIfNeeded()
                    .withMode(CreateMode.PERSISTENT)
                    .forPath(path, data.getBytes(StandardCharsets.UTF_8));
            logger.info("create persistent node, path:{}, data:{}", path, data);
//            zkClient.create(path, // ?????????????????????
//                    data.getBytes(StandardCharsets.UTF_8), // ???????????????UTF-8??????
//                    ZooDefs.Ids.OPEN_ACL_UNSAFE, // ???????????? ??????open
//                    CreateMode.PERSISTENT); // ??????????????????????????????????????????????????????????????????????????????
            return true;
        } catch (Exception e) {
            logger.error("create persistent node exception, path:{}, data:{}, exception:{}",
                    path, data, e.getMessage());
            return false;
        }
    }

    /**
     * ??????????????????
     *
     * @param path
     * @param data
     * @return
     */
    public boolean createEphemeralNode(String path, String data) {
        try {
            zkClient.create()
                    .creatingParentsIfNeeded()
                    .withMode(CreateMode.EPHEMERAL)
                    .forPath(path, data.getBytes(StandardCharsets.UTF_8));
//            zkClient.create(path, // ?????????????????????
//                    data.getBytes(StandardCharsets.UTF_8), // ???????????????UTF-8??????
//                    ZooDefs.Ids.OPEN_ACL_UNSAFE, // ???????????? ??????open
//                    CreateMode.EPHEMERAL); // ?????????????????????????????????????????????
            logger.info("create ephemeral node, path:{}, data:{}", path, data);
            return true;
        } catch (Exception e) {
            logger.error("create ephemeral node exception, path:{}, data:{}, exception:{}",
                    path, data, e.getMessage());
            return false;
        }
    }

    /**
     * ?????????????????????
     *
     * @param path
     * @param data
     * @param acl
     * @param createMode
     * @return
     */
    public boolean createCustomNode(String path, String data, List<ACL> acl, CreateMode createMode) {
        try {
            zkClient.create()
                    .creatingParentsIfNeeded()
                    .withMode(createMode)
                    .withACL(acl)
                    .forPath(path, data.getBytes(StandardCharsets.UTF_8));
            logger.info("create custom node, path:{}, data:{}", path, data);
//            zkClient.create(path, data.getBytes(StandardCharsets.UTF_8), acl, createMode);
            return true;
        } catch (Exception e) {
            logger.error("create custom node exception, path:{}, data:{}, exception:{}",
                    path, data, e.getMessage());
            return false;
        }
    }

    /**
     * ????????????
     *
     * @param path
     * @param data
     * @return
     */
    public boolean updateNode(String path, String data) {
        try {
            Stat stat = zkClient.checkExists().forPath(path);
            if (null == stat) {
                logger.error("{} node is not exists", path);
                return false;
            }
            String value = getData(path, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    logger.info("watchedEvent status:{}", event.getState());
                    logger.info("watchedEvent path:{}", event.getPath());
                    logger.info("watchedEvent type:{}", event.getType());
                }
            });
            zkClient.setData().withVersion(stat.getAversion()).forPath(path, value.getBytes(StandardCharsets.UTF_8));
            logger.info("{} node data is updated. old data:{}, new data:{}", path, value, data);
            // version:-1 ??????zk??????????????????????????????????????????
//            zkClient.setData(path, data.getBytes(StandardCharsets.UTF_8), -1);
            return true;
        } catch (Exception e) {
            logger.error("update node exception, path:{}, data:{}, exception:{}",
                    path, data, e.getMessage());
            return false;
        }
    }

    /**
     * ????????????
     *
     * @param path
     * @return
     */
    public boolean deleteNode(String path) {
        try {
            zkClient.delete().deletingChildrenIfNeeded().forPath(path);
            logger.info("{} node is deleted", path);
            // version:-1 ????????????????????????
//            zkClient.delete(path, -1);
            return true;
        } catch (Exception e) {
            logger.error("delete node exception, path:{}, exception:{}", path, e.getMessage());
            return false;
        }
    }

    /**
     * ????????????????????????
     *
     * @param path
     * @return
     */
    public Stat exists(String path) {
        try {
            return zkClient.checkExists().forPath(path);
        } catch (Exception e) {
            logger.error("exists exception, path:{}, exception:{}", path, e.getMessage());
            return null;
        }
    }

//    /**
//     * ????????????????????????????????????????????????(??????/??????/??????)
//     *
//     * @param path
//     * @param watcher
//     * @return
//     */
//    public Stat exists(String path, Watcher watcher) {
//        try {
//            return zkClient.newWatcherRemoveCuratorFramework().
////            return zkClient.exists(path, watcher);
//        } catch (Exception e) {
//            logger.error("exists exception, path:{}, exception:{}", path, e.getMessage());
//            return null;
//        }
//    }

    /**
     * ??????????????????????????????(?????????????????????)
     *
     * @param path
     * @return
     */
    public List<String> getChildren(String path) {
        try {
            return zkClient.getChildren().forPath(path);
//            return zkClient.getChildren(path, false);
        } catch (Exception e) {
            logger.error("get children exception, path:{}, exception:{}", path, e.getMessage());
            return null;
        }
    }

    /**
     * ???????????????data
     *
     * @param path
     * @param watcher
     * @return
     */
    public String getData(String path, Watcher watcher) {
        Stat stat = null;
        byte[] data = null;
        try {
            stat = new Stat();
            data = zkClient.getData().usingWatcher(watcher).forPath(path);
//            data = zkClient.getData(path, watcher, stat);
            return new String(data);
        } catch (Exception e) {
            logger.error("get data exception, path:{}, data:{}, exception:{}",
                    path, data, e.getMessage());
            return null;
        }
    }

    /**
     * ???????????????zk????????????GrpcServer
     *
     * @param grpcServerIp
     * @param grpcServerPort
     * @return
     */
    public boolean register(String grpcServerIp, int grpcServerPort) {
        String path = "/grpc_services";
        Stat stat = null;
        String currTime = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        try {
            stat = exists(path);
            if (stat == null) {
                createPersistentNode(path, currTime);
            }
        } catch (Exception e) {
            logger.error("{} node create exception:{}", path, e.getMessage());
        }
        String grpcServerAddr = path + "/" + grpcServerIp + ":" + grpcServerPort;
        try {
            stat = exists(grpcServerAddr);
            if (stat == null) {
                try {
                    createEphemeralNode(grpcServerAddr, currTime);
                } catch (Exception e) {
                    logger.error("create grpcServerAddr {} node exception:{}", grpcServerAddr, e.getMessage());
                    return false;
                }
            }
            try {
                updateNode(grpcServerAddr, currTime);
            } catch (Exception e) {
                logger.error("update grpcServerAddr {} node exception:{}", grpcServerAddr, e.getMessage());
                return false;
            }
        } catch (Exception e) {
            logger.error("add grpcServerAddr {} node exception:{}", grpcServerAddr, e.getMessage());
            return false;
        }
        return true;
    }
}
