package com.furenqiang.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.furenqiang.common.utils.PageUtils;
import com.furenqiang.gulimall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author Eric
 * @email www.1726894668@foxmail.com
 * @date 2021-06-24 11:18:42
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> listWithTree();

    boolean removeMenusByIds(List<Long> asList);

}

