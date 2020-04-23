package com.yss.springcloud.service.Impl;

import com.yss.springcloud.dao.StorageDao;
import com.yss.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: duhao
 * @date: 2020/4/23 8:02
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");
          storageDao.decrease(productId,count);
          log.info("------->storage-service中扣减库存结束");
    }
}
