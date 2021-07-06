package com.furenqiang.gulimall.product.dao;

import com.furenqiang.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author Eric
 * @email www.1726894668@foxmail.com
 * @date 2021-06-24 11:18:42
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
