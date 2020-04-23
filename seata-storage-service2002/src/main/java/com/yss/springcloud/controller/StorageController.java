package com.yss.springcloud.controller;

import com.yss.springcloud.domain.CommonResult;
import com.yss.springcloud.service.StorageService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: duhao
 * @date: 2020/4/23 8:04
 */
@RestController
public class StorageController {

    @Resource
    private StorageService storageService;
    @PostMapping(value = "/storage/decrease")
    public CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count){

        storageService.decrease(productId,count);
        return new CommonResult(200,"扣减成功");
    }
}
