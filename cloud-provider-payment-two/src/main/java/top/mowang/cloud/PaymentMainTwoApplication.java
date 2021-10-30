package top.mowang.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * SpringCloud-Demo
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/29 22:39
 **/
@SpringBootApplication
@EnableOpenApi
@MapperScan("top.mowang.cloud.mapper")
@EnableEurekaClient
@EnableDiscoveryClient
public class PaymentMainTwoApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMainTwoApplication.class,args);
    }
}
