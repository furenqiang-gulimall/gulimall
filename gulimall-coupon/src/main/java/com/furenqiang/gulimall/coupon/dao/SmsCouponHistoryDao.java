package com.furenqiang.gulimall.coupon.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.furenqiang.gulimall.coupon.entity.SmsCouponHistoryEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券领取历史记录
 * 
 * @author Eric
 * @email www.1726894668@foxmail.com
 * @date 2021-06-24 14:40:32
 */
@Mapper
public interface SmsCouponHistoryDao extends BaseMapper<SmsCouponHistoryEntity> {
	
}
