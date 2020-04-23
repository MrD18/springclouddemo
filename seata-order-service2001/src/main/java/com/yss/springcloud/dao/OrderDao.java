package com.yss.springcloud.dao;

import com.yss.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: duhao
 * @date: 2020/4/15 17:09
 */
@Mapper
public interface OrderDao {
    //新建订单
    void create(Order order);
    //修改订单状态,0改为1
    void  update(@Param("userId")Long userId,@Param("status") Integer status);
}
