package top.mowang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * SpringCloud-Demo
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/31 14:22
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMainConsulApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMainConsulApplication.class,args);
    }
}
