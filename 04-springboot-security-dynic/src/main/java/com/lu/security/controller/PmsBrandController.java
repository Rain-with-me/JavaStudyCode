package com.lu.security.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lu.security.common.result.CommonPage;
import com.lu.security.common.result.CommonResult;
import com.lu.security.entity.pms.PmsBrand;
import com.lu.security.service.pms.PmsBrandService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 品牌表 前端控制器
 * </p>
 *
 * @author mybatis自动生成
 * @since 2022-09-23
 */
@RestController
@RequestMapping("/brand")
public class PmsBrandController {

    @Autowired
    private PmsBrandService pmsBrandService;

    /**
     * @Description: 分页获取品牌列表
     * @Author: 雨同我
     * @DateTime: 2022/9/23 8:46
    */

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage> getList(@RequestParam(value = "keyword", required = false) String keyword,
                                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        Page<PmsBrand> page = new Page<PmsBrand>(pageNum,pageSize);
        LambdaQueryWrapper<PmsBrand> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNoneBlank(keyword)){
            wrapper.like(PmsBrand::getName,keyword);
        }
        Page<PmsBrand> brandPage = pmsBrandService.getBaseMapper().selectPage(page,wrapper);
        return CommonResult.success(CommonPage.restPage(brandPage));
    }
}

