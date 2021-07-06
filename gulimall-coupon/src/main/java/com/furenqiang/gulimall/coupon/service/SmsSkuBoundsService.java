package com.furenqiang.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.furenqiang.common.utils.PageUtils;
import com.furenqiang.gulimall.coupon.entity.SmsSkuBoundsEntity;

import java.util.Map;

/**
 * 商品sku积分设置
 *
 * @author Eric
 * @email www.1726894668@foxmail.com
 * @date 2021-06-24 14:40:32
 */
public interface SmsSkuBoundsService extends IService<SmsSkuBoundsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

