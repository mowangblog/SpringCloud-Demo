package top.mowang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * SpringCloud-Demo
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/31 19:51
 **/
@SpringBootApplication
@EnableEurekaClient
@SuppressWarnings("all")
//@EnableHystrix 里面有@EnableCircuitBreaker
@EnableCircuitBreaker
public class PaymentHystrixMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMainApplication.class, args);
    }
}
