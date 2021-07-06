package com.furenqiang.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.furenqiang.common.utils.PageUtils;
import com.furenqiang.gulimall.coupon.entity.SmsCouponEntity;

import java.util.Map;

/**
 * 优惠券信息
 *
 * @author Eric
 * @email www.1726894668@foxmail.com
 * @date 2021-06-24 14:40:32
 */
public interface SmsCouponService extends IService<SmsCouponEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

