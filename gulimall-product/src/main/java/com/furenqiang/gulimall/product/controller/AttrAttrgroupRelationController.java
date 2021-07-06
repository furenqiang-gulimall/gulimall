package com.furenqiang.gulimall.product.controller;

import com.furenqiang.common.utils.PageUtils;
import com.furenqiang.common.utils.R;
import com.furenqiang.gulimall.product.entity.AttrAttrgroupRelationEntity;
import com.furenqiang.gulimall.product.feign.CouponFeignService;
import com.furenqiang.gulimall.product.service.AttrAttrgroupRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;



/**
 * 属性&属性分组关联
 *
 * @author Eric
 * @email www.1726894668@foxmail.com
 * @date 2021-06-24 14:01:30
 */
@RefreshScope
@RestController
@RequestMapping("product/attrattrgrouprelation")
public class AttrAttrgroupRelationController {

    @Value("${product.test.nacos}")
    private String dbUname;

    @Autowired
    private AttrAttrgroupRelationService attrAttrgroupRelationService;

    @Autowired
    private CouponFeignService couponFeignService;

    /**
     * 列表
     */
    @RequestMapping("/listFeign")
    //@RequiresPermissions("product:attrattrgrouprelation:list")
    public R listFeign(@RequestParam Map<String, Object> params){
        return couponFeignService.list(params);
    }

    /**
     * 列表
     */
    @RequestMapping("/listFeignConfig")
    //@RequiresPermissions("product:attrattrgrouprelation:list")
    public String listFeignConfig(){
        return dbUname+":";
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:attrattrgrouprelation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = attrAttrgroupRelationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:attrattrgrouprelation:info")
    public R info(@PathVariable("id") Long id){
		AttrAttrgroupRelationEntity attrAttrgroupRelation = attrAttrgroupRelationService.getById(id);

        return R.ok().put("attrAttrgroupRelation", attrAttrgroupRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:attrattrgrouprelation:save")
    public R save(@RequestBody AttrAttrgroupRelationEntity attrAttrgroupRelation){
		attrAttrgroupRelationService.save(attrAttrgroupRelation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:attrattrgrouprelation:update")
    public R update(@RequestBody AttrAttrgroupRelationEntity attrAttrgroupRelation){
		attrAttrgroupRelationService.updateById(attrAttrgroupRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:attrattrgrouprelation:delete")
    public R delete(@RequestBody Long[] ids){
		attrAttrgroupRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
