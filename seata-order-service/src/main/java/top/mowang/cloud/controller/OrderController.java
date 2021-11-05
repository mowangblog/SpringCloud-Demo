package top.mowang.cloud.controller;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Xuan Li
 * @since 2021-11-05
 */

import org.springframework.web.bind.annotation.GetMapping;
import top.mowang.cloud.pojo.CommonResult;
import top.mowang.cloud.pojo.TOrder;
import top.mowang.cloud.service.ITOrderService;

import javax.annotation.Resource;

@RestController
@SuppressWarnings("all")
public class OrderController {
    @Resource
    private ITOrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(TOrder order) {
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}


