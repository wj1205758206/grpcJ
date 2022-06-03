package com.example.grpcj.common.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "grpc.client")
public class GrpcClientConfig {
    private String zkAddress;
    private int keepAliveTime;
    private int keepAliveTimeout;
    private boolean keepAliveWithoutCalls;
    private String loadBalancingPolicy;
    private int idleTimeout;
    private int maxRetryAttempts;

    public String getZkAddress() {
        return zkAddress;
    }

    public void setZkAddress(String zkAddress) {
        this.zkAddress = zkAddress;
    }

    public int getKeepAliveTime() {
        return keepAliveTime;
    }

    public void setKeepAliveTime(int keepAliveTime) {
        this.keepAliveTime = keepAliveTime;
    }

    public int getKeepAliveTimeout() {
        return keepAliveTimeout;
    }

    public void setKeepAliveTimeout(int keepAliveTimeout) {
        this.keepAliveTimeout = keepAliveTimeout;
    }

    public boolean isKeepAliveWithoutCalls() {
        return keepAliveWithoutCalls;
    }

    public void setKeepAliveWithoutCalls(boolean keepAliveWithoutCalls) {
        this.keepAliveWithoutCalls = keepAliveWithoutCalls;
    }

    public String getLoadBalancingPolicy() {
        return loadBalancingPolicy;
    }

    public void setLoadBalancingPolicy(String loadBalancingPolicy) {
        this.loadBalancingPolicy = loadBalancingPolicy;
    }

    public int getIdleTimeout() {
        return idleTimeout;
    }

    public void setIdleTimeout(int idleTimeout) {
        this.idleTimeout = idleTimeout;
    }

    public int getMaxRetryAttempts() {
        return maxRetryAttempts;
    }

    public void setMaxRetryAttempts(int maxRetryAttempts) {
        this.maxRetryAttempts = maxRetryAttempts;
    }

    @Override
    public String toString() {
        return "GrpcClientConfig{" +
                "zkAddress='" + zkAddress + '\'' +
                ", keepAliveTime=" + keepAliveTime +
                ", keepAliveTimeout=" + keepAliveTimeout +
                ", keepAliveWithoutCalls=" + keepAliveWithoutCalls +
                ", loadBalancingPolicy='" + loadBalancingPolicy + '\'' +
                ", idleTimeout=" + idleTimeout +
                ", maxRetryAttempts=" + maxRetryAttempts +
                '}';
    }
}
