package top.mowang.cloud.mapper;

import org.apache.ibatis.annotations.Param;
import top.mowang.cloud.pojo.Account;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.math.BigDecimal;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Xuan Li
 * @since 2021-11-05
 */
public interface TAccountMapper extends BaseMapper<Account> {
    /**
     * 扣减账户余额
     */
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
