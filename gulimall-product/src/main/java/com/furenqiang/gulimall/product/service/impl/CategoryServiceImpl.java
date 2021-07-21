package com.furenqiang.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.furenqiang.common.utils.PageUtils;
import com.furenqiang.common.utils.Query;
import com.furenqiang.gulimall.product.dao.CategoryDao;
import com.furenqiang.gulimall.product.entity.CategoryEntity;
import com.furenqiang.gulimall.product.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        //1、查出所有分类
        List<CategoryEntity> categoryEntities = baseMapper.selectList(null);

        //2-1、筛选出一级分类
        List<CategoryEntity> level1Menus = categoryEntities.stream().filter((categoryEntity) -> {
            return categoryEntity.getParentCid() == 0;
        }).map((categoryEntity)->{
            categoryEntity.setChildren(getChildrenMenu(categoryEntity,categoryEntities));
            return categoryEntity;
        }).sorted((menu1,menu2)->{
            return (menu1.getSort()==null?0:menu1.getSort())-(menu2.getSort()==null?0:menu2.getSort());
        }).collect(Collectors.toList());
        return level1Menus;
    }

    @Override
    public boolean removeMenusByIds(List<Long> asList) {
        baseMapper.deleteBatchIds(asList);
        return true;
    }

    private List<CategoryEntity> getChildrenMenu(CategoryEntity categoryEntity, List<CategoryEntity> categoryEntities) {
        List<CategoryEntity> children = categoryEntities.stream().filter((entity) -> {
            return entity.getParentCid()==categoryEntity.getCatId();
        }).map((entity) -> {
            entity.setChildren(getChildrenMenu(entity,categoryEntities));
            return entity;
        }).sorted((menu1,menu2)->{
            return (menu1.getSort()==null?0:menu1.getSort())-(menu2.getSort()==null?0:menu2.getSort());
        }).collect(Collectors.toList());
        return children;
    }

}