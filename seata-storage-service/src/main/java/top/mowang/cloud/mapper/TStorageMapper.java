package top.mowang.cloud.mapper;

import org.apache.ibatis.annotations.Param;
import top.mowang.cloud.pojo.TStorage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Xuan Li
 * @since 2021-11-05
 */
public interface TStorageMapper extends BaseMapper<TStorage> {
    /**
     * 扣减库存
     */
    void decrease(@Param("productId") Long productId,@Param("count") Integer count);
}
