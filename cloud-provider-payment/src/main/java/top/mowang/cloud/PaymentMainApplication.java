package top.mowang.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
public class PaymentMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMainApplication.class,args);
    }
}
