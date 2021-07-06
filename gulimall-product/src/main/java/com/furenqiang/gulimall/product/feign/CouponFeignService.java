package com.furenqiang.gulimall.product.feign;

import com.furenqiang.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value = "gulimall-coupon")
public interface CouponFeignService {

    @RequestMapping("/product/smscoupon/list")
    public R list(@RequestParam Map<String, Object> params);
}
