package top.mowang.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SpringCloud-Demo
 *  刷新请求 curl -X POST "http://localhost:3355/actuator/refresh"
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/11/01 18:37
 **/
@RestController
@RefreshScope
public class ConfigClientController
{
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo()
    {
        return configInfo;
    }
}
