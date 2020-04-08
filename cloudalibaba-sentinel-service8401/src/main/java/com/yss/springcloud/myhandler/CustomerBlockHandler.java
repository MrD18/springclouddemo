package com.yss.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yss.springcloud.entity.CommonResult;

/**自定义异常类
 * @author: duhao
 * @date: 2020/4/8 10:54
 */

public class CustomerBlockHandler {

public static CommonResult handleException1(BlockException exception){
    return new CommonResult(2020,"客户自定义的限流处理信息...Customer handleException1");
}

    public static CommonResult handleException2(BlockException exception){
        return new CommonResult(2020,"客户自定义的限流处理信息...Customer handleException2");
    }
}
