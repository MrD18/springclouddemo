package com.yss.springcloud.controller;

import com.yss.springcloud.domain.CommonResult;
import com.yss.springcloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author: duhao
 * @date: 2020/4/23 10:50
 */
@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;
    @PostMapping(value = "/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money){
        accountService.decrease(userId,money);

        return  new CommonResult(200,"扣减成功");
    }
}
