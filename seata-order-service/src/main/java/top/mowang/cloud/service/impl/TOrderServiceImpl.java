package top.mowang.cloud.service.impl;

import io.seata.spring.annotation.GlobalTransactional;
import top.mowang.cloud.pojo.TOrder;
import top.mowang.cloud.mapper.TOrderMapper;
import top.mowang.cloud.service.AccountService;
import top.mowang.cloud.service.ITOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Xuan Li
 * @since 2021-11-05
 */
import lombok.extern.slf4j.Slf4j;

import top.mowang.cloud.service.StorageService;

import javax.annotation.Resource;

@Service
@Slf4j
@SuppressWarnings("all")
public class TOrderServiceImpl extends ServiceImpl<TOrderMapper, TOrder> implements ITOrderService  {
    @Resource
    private TOrderMapper orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;

    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     * 简单说：下订单->扣库存->减余额->改状态
     */
    @Override
    //rollbackFor = Exception.class表示对任意异常都进行回滚
    @GlobalTransactional(name = "mowang-create-order",rollbackFor = Exception.class)
    public void create(TOrder order) {
        log.info("----->开始新建订单");
        //1 新建订单
        orderDao.create(order);

        //2 扣减库存
        log.info("----->订单微服务开始调用库存，做扣减Count");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("----->订单微服务开始调用库存，做扣减end");

        //3 扣减账户
        log.info("----->订单微服务开始调用账户，做扣减Money");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("----->订单微服务开始调用账户，做扣减end");

        //4 修改订单状态，从零到1,1代表已经完成
        log.info("----->修改订单状态开始");
        orderDao.updateOrder(order.getUserId(),0);
        log.info("----->修改订单状态结束");

        log.info("----->下订单结束了，O(∩_∩)O哈哈~");
    }
}

