package top.mowang.cloud.service.impl;

import top.mowang.cloud.pojo.Payment;
import top.mowang.cloud.mapper.PaymentMapper;
import top.mowang.cloud.service.IPaymentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Xuan Li
 * @since 2021-10-29
 */
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements IPaymentService {

}
