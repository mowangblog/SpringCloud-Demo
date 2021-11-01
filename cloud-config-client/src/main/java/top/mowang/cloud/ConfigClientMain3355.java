package top.mowang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * SpringCloud-Demo
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/11/01 18:36
 **/
@EnableEurekaClient
@SpringBootApplication
public class ConfigClientMain3355
{
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain3355.class, args);
    }
}

