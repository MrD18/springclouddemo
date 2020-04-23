package com.yss.springcloud.service;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author: duhao
 * @date: 2020/4/23 10:01
 */

public interface AccountService {
    /*
   扣减账户余额
    */
    void decrease(Long userId,BigDecimal money);
}
