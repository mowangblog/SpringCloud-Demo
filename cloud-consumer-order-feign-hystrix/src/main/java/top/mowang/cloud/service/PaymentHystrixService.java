package top.mowang.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.mowang.cloud.pojo.CommonResult;
import top.mowang.cloud.pojo.Payment;

/**
 * SpringCloud-Demo
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/31 16:36
 **/
@Component
@FeignClient(value = "cloud-provider-hystrix-payment",//
        fallback = PaymentFallbackService.class)//指定该服务的服务降级类
@SuppressWarnings("all")
public interface PaymentHystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeOut(@PathVariable("id") Integer id);
}

