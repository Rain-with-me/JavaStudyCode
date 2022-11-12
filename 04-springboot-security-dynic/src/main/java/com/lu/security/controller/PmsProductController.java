package com.lu.security.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lu.security.common.result.CommonPage;
import com.lu.security.common.result.CommonResult;
import com.lu.security.dao.dto.PmsProductQueryParam;
import com.lu.security.entity.pms.PmsBrand;
import com.lu.security.entity.pms.PmsProduct;
import com.lu.security.service.pms.PmsProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 商品信息 前端控制器
 * </p>
 *
 * @author mybatis自动生成
 * @since 2022-09-23
 */
@RestController
@RequestMapping("/product")
public class PmsProductController {

    @Autowired
    private PmsProductService pmsProductService;

    @ApiOperation("查询商品")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage> getList(@RequestBody PmsProductQueryParam productQueryParam,
                                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        Page<PmsProduct> page = new Page<>(pageNum,pageSize);
        Page<PmsProduct> brandPage = pmsProductService.page(page);
        return CommonResult.success(CommonPage.restPage(brandPage));
    }

}

