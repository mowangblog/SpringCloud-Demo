package top.mowang.cloud.service;

import org.springframework.stereotype.Component;

/**
 * SpringCloud-Demo
 *
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/31 21:55
 **/
@Component
@SuppressWarnings("all")
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfoOk(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfoOK ,o(╥﹏╥)o 暂时无法提供服务，请稍后重试";
    }

    @Override
    public String paymentInfoTimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfoTimeOut ,o(╥﹏╥)o 暂时无法提供服务，请稍后重试";
    }
}
