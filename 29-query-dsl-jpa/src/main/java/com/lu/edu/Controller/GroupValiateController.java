package com.lu.edu.Controller;

import com.lu.edu.config.ValiteGroup;
import com.lu.edu.entity.AdminEntity;
import com.lu.edu.entity.QAdminEntity;
import com.lu.edu.entity.UserDiyEntity;
import com.lu.edu.utils.result.CommonResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 雨同我
 * @Description:   分组参数校验
 * 注意点： @Validated，单参数校验需要再controller进行添加
 * @DateTime: 2023/11/27 11:09
 **/
@Validated
@RestController
public class GroupValiateController {

    @PostMapping("/groupValidate")
    public CommonResult groupValidate(@RequestBody @Validated(value = ValiteGroup.Crud.Create.class) UserDiyEntity userDiy) {

        return CommonResult.success("成功");
    }

    @PostMapping("/groupValidateDefault")
    public CommonResult groupValidateDefault(@RequestBody @Validated() UserDiyEntity userDiy) {

        return CommonResult.success("成功");
    }

}
