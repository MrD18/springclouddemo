package com.yss.springcloud.service;

import org.apache.ibatis.annotations.Param;

/**
 * @author: duhao
 * @date: 2020/4/23 8:02
 */
public interface StorageService {
    //扣减库存信息
    void decrease( Long productId, Integer count);
}
