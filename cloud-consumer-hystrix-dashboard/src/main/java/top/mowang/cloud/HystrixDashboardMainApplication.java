package top.mowang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * SpringCloud-Demo
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/11/01 12:33
 **/
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMainApplication.class,args);
    }
}
