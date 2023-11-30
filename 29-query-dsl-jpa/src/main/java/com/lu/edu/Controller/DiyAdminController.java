package com.lu.edu.Controller;

import com.lu.edu.entity.AdminEntity;
import com.lu.edu.entity.GroupDiyEntity;
import com.lu.edu.entity.UserDiyEntity;
import com.lu.edu.interfaces.AdminRepository;
import com.lu.edu.interfaces.UserRepository;
import com.lu.edu.utils.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;


/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2023/11/17 14:50
 **/
@RestController
public class DiyAdminController {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/diyByUser")
    public CommonResult diyByUser(@RequestBody AdminEntity adminEntity) {
        List<AdminEntity> byName = adminRepository.findByName(adminEntity.getUsername());
        return CommonResult.success(byName);
    }
    @PostMapping("/diyInsert")
    public CommonResult insertAdmin(@RequestBody AdminEntity adminEntity) {
        int i = adminRepository.insertAdmin(adminEntity);
        return CommonResult.success(i==1);
    }
    @PostMapping("/updateByName")
    public CommonResult updateByName(@RequestBody AdminEntity adminEntity) {
        int i = adminRepository.updateByName(adminEntity);
        return CommonResult.success(i==1);
    }
    
    
    /** 
     * @Description: 测试实体类注解 mappedBy  【里面有json循环依赖问题】
     * @Author: 雨同我
     * @DateTime: 2023/11/22 11:25
     * @param: null: 
     * @return: 
    */

    @PostMapping("/saveMappeBy")
    public CommonResult saveMappeBy(@RequestBody UserDiyEntity userDiyDto) {
//        GroupDiyEntity groupDiy = GroupDiyEntity.builder().userDiy(userDiy).build();
        UserDiyEntity userDiy = UserDiyEntity.builder().username(userDiyDto.getUsername()).sex(userDiyDto.getSex()).email(userDiyDto.getEmail()).build();

        LinkedList<GroupDiyEntity> list = new LinkedList<>();
        list.add(GroupDiyEntity.builder().userDiy(userDiy).group_name("交通").build());
        System.out.println(userDiyDto.getGroupDiys());
        userDiy.setGroupDiys(list);

        UserDiyEntity save = userRepository.save(userDiy);
        return CommonResult.success(save);
    }
}
