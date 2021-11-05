package top.mowang.cloud.service;

import top.mowang.cloud.pojo.TStorage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Xuan Li
 * @since 2021-11-05
 */
public interface StorageService extends IService<TStorage> {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
