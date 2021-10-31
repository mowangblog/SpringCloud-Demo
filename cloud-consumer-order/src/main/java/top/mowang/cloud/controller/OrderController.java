package top.mowang.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import top.mowang.cloud.lb.LoadBalancer;
import top.mowang.cloud.pojo.CommonResult;
import top.mowang.cloud.pojo.Payment;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

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

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/order/payment")
    public CommonResult<Object> create(@RequestBody Payment payment) {
        log.info("插入数据:" + payment.toString());
        return restTemplate.postForObject(PAY_URL + "/payment", payment, CommonResult.class);
    }

    @GetMapping("/order/payment/{id}")
    public CommonResult<Payment> paymentById(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PAY_URL + "/payment/" + id, CommonResult.class);
    }

    @GetMapping("/order/payment/getForEntity/{id}")
    public CommonResult<Payment> getPaypaymentById2(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAY_URL + "/payment/" + id, CommonResult.class);

        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();//getForObject()
        } else {
            return new CommonResult<>(444, "操作失败");
        }
    }

    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT");

        if (instances == null || instances.size() <= 0) {
            return null;
        }

        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        log.info("请求地址是：{}",uri);
        return restTemplate.getForObject(uri + "/payment/lb", String.class);

    }

}
