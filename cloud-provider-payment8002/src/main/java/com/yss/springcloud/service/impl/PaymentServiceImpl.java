package com.yss.springcloud.service.impl;

import com.yss.springcloud.dao.PaymentDao;
import com.yss.springcloud.entity.Payment;
import com.yss.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }
}