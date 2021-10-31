package top.mowang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * SpringCloud-Demo
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/30 12:04
 **/
@SuppressWarnings("all")
@EnableOpenApi
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderMainFeignHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderMainFeignHystrixApplication.class,args);
    }
}
