package top.mowang.cloud.service.impl;

import org.springframework.stereotype.Component;
import top.mowang.cloud.pojo.CommonResult;
import top.mowang.cloud.pojo.Payment;
import top.mowang.cloud.service.PaymentService;
/**
 * SpringCloud-Demo
 *
 * @author : Xuan Li<mowangblog@qq.com>
 * @website : https://mowangblog.top
 * @date : 2021/11/04 21:20
 **/
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}


