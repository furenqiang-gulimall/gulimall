package com.furenqiang.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.furenqiang.common.utils.PageUtils;
import com.furenqiang.gulimall.order.entity.OmsOrderReturnReasonEntity;

import java.util.Map;

/**
 * 退货原因
 *
 * @author Eric
 * @email www.1726894668@foxmail.com
 * @date 2021-06-24 15:03:22
 */
public interface OmsOrderReturnReasonService extends IService<OmsOrderReturnReasonEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

