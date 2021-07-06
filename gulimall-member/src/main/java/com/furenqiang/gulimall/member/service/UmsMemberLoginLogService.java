package com.furenqiang.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.furenqiang.common.utils.PageUtils;
import com.furenqiang.gulimall.member.entity.UmsMemberLoginLogEntity;

import java.util.Map;

/**
 * 会员登录记录
 *
 * @author Eric
 * @email www.1726894668@foxmail.com
 * @date 2021-06-24 15:05:20
 */
public interface UmsMemberLoginLogService extends IService<UmsMemberLoginLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

