package top.mowang.cloud.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import top.mowang.cloud.pojo.CommonResult;
import top.mowang.cloud.pojo.Payment;
import top.mowang.cloud.service.IPaymentService;
import top.mowang.cloud.service.impl.PaymentServiceImpl;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Xuan Li
 * @since 2021-10-29
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    IPaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/paymentPage/{page}")
    public CommonResult<Page<Payment>> paymentPage(@PathVariable("page") Integer currentPage) {
        Page<Payment> page = new Page<>(currentPage, 5);
        CommonResult<Page<Payment>> pageCommonResult = new CommonResult<>(200, "success");
        pageCommonResult.setData(paymentService.page(page, null));
        return pageCommonResult;
    }

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> paymentById(@PathVariable("id") Integer id) {
        Payment payment = paymentService.getById(id);
        CommonResult<Payment> paymentCommonResult = new CommonResult<>(200,"success,端口号："+serverPort);
        paymentCommonResult.setData(payment);
        return paymentCommonResult;
    }

    @PostMapping("/payment")
    public CommonResult<Object> payment(@RequestBody Payment payment) {
        log.info("插入数据"+payment.toString());
        boolean save = paymentService.save(payment);
        if (save) {
            CommonResult<Object> success = new CommonResult<>(200, "success,插入数据成功");
            success.setData(payment);
            return success;
        } else {
            return new CommonResult<Object>(500, "fail");
        }
    }

    @PutMapping("/payment")
    public CommonResult<Object> paymentPut(Payment payment) {
        log.info("修改数据"+payment.toString());
        boolean save = paymentService.updateById(payment);
        if (save) {
            return new CommonResult<Object>(200, "success");
        } else {
            return new CommonResult<Object>(500, "fail");
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println(service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getServiceId());
            System.out.println(instance.getHost());
            System.out.println(instance.getPort());
            System.out.println(instance.getUri());
        }
        return discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        //返回服务接口
        return serverPort;
    }

}

