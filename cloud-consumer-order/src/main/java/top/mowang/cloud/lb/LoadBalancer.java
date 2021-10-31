package top.mowang.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/31 16:05
 **/
public interface LoadBalancer {
    /**
     * 传入服务器集群根据第几次请求，使用cas自旋锁轮询返回服务器实例
     * @param serviceInstances
     * @return ServiceInstance
     * @description: 返回服务器实例
     * @author: Xuan Li
     * @date: 2021/10/31 16:05
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
