package top.mowang.cloud.service;

import org.springframework.web.bind.annotation.RequestParam;
import top.mowang.cloud.pojo.Account;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Xuan Li
 * @since 2021-11-05
 */
public interface AccountService extends IService<Account> {
    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money 金额
     */
    void decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
