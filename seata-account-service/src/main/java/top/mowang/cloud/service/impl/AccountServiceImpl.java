package top.mowang.cloud.service.impl;

import lombok.extern.slf4j.Slf4j;
import top.mowang.cloud.pojo.Account;
import top.mowang.cloud.mapper.TAccountMapper;
import top.mowang.cloud.service.AccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Xuan Li
 * @since 2021-11-05
 */
@Service
@Slf4j
public class AccountServiceImpl extends ServiceImpl<TAccountMapper, Account> implements AccountService {
    @Resource
    TAccountMapper accountDao;

    /**
     * 扣减账户余额
     */
    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------->account-service中扣减账户余额开始");
        //模拟超时异常，全局事务回滚
        //暂停几秒钟线程
        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
        accountDao.decrease(userId,money);
        log.info("------->account-service中扣减账户余额结束");
    }

}
