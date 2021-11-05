package top.mowang.cloud.service.impl;

import lombok.extern.slf4j.Slf4j;
import top.mowang.cloud.pojo.TStorage;
import top.mowang.cloud.mapper.TStorageMapper;
import top.mowang.cloud.service.StorageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
public class StorageServiceImpl extends ServiceImpl<TStorageMapper, TStorage> implements StorageService {

    @Resource
    private TStorageMapper storageDao;

    /**
     * 扣减库存
     */
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始productId:{},count:{}",productId,count);
        storageDao.decrease(productId,count);
        log.info("------->storage-service中扣减库存结束");
    }

}
