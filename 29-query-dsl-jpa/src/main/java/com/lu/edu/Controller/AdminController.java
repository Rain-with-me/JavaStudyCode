package com.lu.edu.Controller;

import com.lu.edu.entity.AdminEntity;
import com.lu.edu.entity.vo.PageSizeVo;
import com.lu.edu.interfaces.AdminRepository;
import com.lu.edu.utils.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2023/11/13 10:33
 **/

@RestController
public class AdminController {
    @Autowired
    private AdminRepository adminRepository;

    /**
     * @Description: 自定义条件查询和查询一个，可以看看api即可
     * @Author: 雨同我
     * @DateTime: 2023/11/13 9:53
     */
//    TODO 优化为传参解决
    @PostMapping("diyAll")
    public CommonResult adminRepositorySelect(){
        AdminEntity adminEntity = new AdminEntity();
        adminEntity.setAid(10001);
        adminEntity.setUsername("管理员");
        List<AdminEntity> diyAll = adminRepository.findAll(Example.of(adminEntity));
        return CommonResult.success(diyAll);
    }

    @PostMapping("sortSelect")
    public CommonResult testSort() {
//        sort是private，不能创建
//        List<AdminEntity> list = adminRepository.findAll(
//                new Sort(Sort.Direction.DESC,new LinkedList<>().add("aid")));
        List<AdminEntity> aid = adminRepository.findAll(Sort.by(Sort.Direction.DESC, "aid"));
        return CommonResult.success(aid);
    }

    /**
     * @Description: 里面的从0开始，0是第一页
     * 这里自定义异常，来返回所需要的message
     *
     * @Author: 雨同我
     * @DateTime: 2023/11/13 10:27
     * @param: null:
     * @return:
     */
    @PostMapping("pageSelect")
    public CommonResult pageSelect(@Validated @RequestBody PageSizeVo pageSizeVo) {
//        sort是private，不能创建
//        List<AdminEntity> list = adminRepository.findAll(
//                new Sort(Sort.Direction.DESC,new LinkedList<>().add("aid")));
        Page<AdminEntity> entityPage = adminRepository.findAll(PageRequest.of(pageSizeVo.getPageNum(), pageSizeVo.getPageSize()));
        return CommonResult.success(entityPage.getContent());
    }
}
