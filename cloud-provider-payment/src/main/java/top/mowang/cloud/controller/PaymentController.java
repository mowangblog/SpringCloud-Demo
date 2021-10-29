package top.mowang.cloud.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import top.mowang.cloud.pojo.CommonResult;
import top.mowang.cloud.pojo.Payment;
import top.mowang.cloud.service.IPaymentService;
import top.mowang.cloud.service.impl.PaymentServiceImpl;

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
        CommonResult<Payment> paymentCommonResult = new CommonResult<>(200,"success");
        paymentCommonResult.setData(payment);
        return paymentCommonResult;
    }

    @PostMapping("/payment")
    public CommonResult<Object> payment(Payment payment) {
        log.info("插入数据"+payment.toString());
        boolean save = paymentService.save(payment);
        if (save) {
            return new CommonResult<Object>(200, "success");
        } else {
            return new CommonResult<Object>(500, "fail");
        }
    }

}

