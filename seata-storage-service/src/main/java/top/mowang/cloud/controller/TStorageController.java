package top.mowang.cloud.controller;


import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import top.mowang.cloud.pojo.CommonResult;
import top.mowang.cloud.service.StorageService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Xuan Li
 * @since 2021-11-05
 */
@RestController
public class TStorageController {
    @Autowired
    private StorageService storageService;

    /**
     * 扣减库存
     */
    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult(200,"扣减库存成功！");
    }

}

