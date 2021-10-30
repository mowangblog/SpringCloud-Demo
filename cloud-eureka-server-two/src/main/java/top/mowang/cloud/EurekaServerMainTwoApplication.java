package top.mowang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * SpringCloud-Demo
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/30 20:30
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerMainTwoApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerMainTwoApplication.class,args);
    }
}

