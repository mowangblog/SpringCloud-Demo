package top.mowang.cloud.service;

import top.mowang.cloud.pojo.TOrder;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Xuan Li
 * @since 2021-11-05
 */
@SuppressWarnings("all")
public interface ITOrderService extends IService<TOrder> {
    void create(TOrder order);
}
