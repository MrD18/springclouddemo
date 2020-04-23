package com.yss.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author: duhao
 * @date: 2020/4/23 9:49
 */
@Mapper
public interface AccountDao {
    /*
    扣减账户余额
     */
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
