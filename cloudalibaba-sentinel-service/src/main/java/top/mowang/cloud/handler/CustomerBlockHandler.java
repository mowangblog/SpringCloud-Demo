package top.mowang.cloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import top.mowang.cloud.pojo.CommonResult;

/**
 * SpringCloud-Demo
 *
 * @author : Xuan Li<mowangblog@qq.com>
 * @website : https://mowangblog.top
 * @date : 2021/11/04 16:13
 **/
public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(4444,"按客戶自定义,global handlerException----1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(4444,"按客戶自定义,global handlerException----2");
    }
}

