package top.mowang.cloud.mapper;

import org.apache.ibatis.annotations.Param;
import top.mowang.cloud.pojo.TOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Xuan Li
 * @since 2021-11-05
 */
@SuppressWarnings("all")
public interface TOrderMapper extends BaseMapper<TOrder> {
    //1 新建订单
    void create(TOrder order);

    //2 修改订单状态，从零改为1
    void updateOrder(@Param("userId") Long userId, @Param("status") Integer status);
}
