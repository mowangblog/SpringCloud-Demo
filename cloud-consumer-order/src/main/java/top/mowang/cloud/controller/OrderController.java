package top.mowang.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.mowang.cloud.pojo.CommonResult;
import top.mowang.cloud.pojo.Payment;

import javax.annotation.Resource;

/**
 * SpringCloud-Demo
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/30 12:06
 **/
@RestController
public class OrderController {
    private static final String PAY_URL = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/order/payment")
    public CommonResult<Object> create(Payment payment){
        return restTemplate.postForObject(PAY_URL+"/payment",payment,CommonResult.class);
    }
    @GetMapping("/order/payment/{id}")
    public CommonResult<Payment> paymentById(@PathVariable("id") Integer id){
        return restTemplate.getForObject(PAY_URL+"/payment/"+id,CommonResult.class);
    }
}
