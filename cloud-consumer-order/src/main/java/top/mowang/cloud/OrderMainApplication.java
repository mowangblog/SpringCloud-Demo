package top.mowang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import springfox.documentation.oas.annotations.EnableOpenApi;
import top.mowang.myrule.MySelfRule;

/**
 * SpringCloud-Demo
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/30 12:04
 **/
@SuppressWarnings("all")
@SpringBootApplication
@EnableOpenApi
@EnableEurekaClient
//Ribbon修改负载均衡算法
//@RibbonClient(name = "CLOUD-PROVIDER-PAYMENT", configuration = MySelfRule.class)
public class OrderMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderMainApplication.class,args);
    }
}
