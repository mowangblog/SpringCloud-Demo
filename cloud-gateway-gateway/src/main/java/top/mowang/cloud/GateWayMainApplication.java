package top.mowang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * SpringCloud-Demo
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/11/01 14:27
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class GateWayMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(GateWayMainApplication.class, args);
    }
}
