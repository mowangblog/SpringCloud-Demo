package top.mowang.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
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
@SuppressWarnings("all")
@RestController
@Slf4j
public class OrderController {
//    private static final String PAY_URL = "http://localhost:8001";
    private static final String PAY_URL = "http://CLOUD-PROVIDER-PAYMENT";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/order/payment")
    public CommonResult<Object> create(@RequestBody Payment payment){
        log.info("插入数据:"+payment.toString());
        return restTemplate.postForObject(PAY_URL+"/payment",payment,CommonResult.class);
    }
    @GetMapping("/order/payment/{id}")
    public CommonResult<Payment> paymentById(@PathVariable("id") Integer id){
        return restTemplate.getForObject(PAY_URL+"/payment/"+id,CommonResult.class);
    }
}
