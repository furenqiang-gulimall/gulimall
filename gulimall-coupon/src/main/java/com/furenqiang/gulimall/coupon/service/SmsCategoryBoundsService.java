package com.furenqiang.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.furenqiang.common.utils.PageUtils;
import com.furenqiang.gulimall.coupon.entity.SmsCategoryBoundsEntity;

import java.util.Map;

/**
 * 商品分类积分设置
 *
 * @author Eric
 * @email www.1726894668@foxmail.com
 * @date 2021-06-24 14:40:32
 */
public interface SmsCategoryBoundsService extends IService<SmsCategoryBoundsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

