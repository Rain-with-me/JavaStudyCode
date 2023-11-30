package com.lu.edu.Controller;

import com.lu.edu.entity.AdminEntity;
import com.lu.edu.entity.QAdminEntity;
import com.lu.edu.entity.UserDiyEntity;
import com.lu.edu.entity.vo.PageSizeVo;
import com.lu.edu.interfaces.AdminRepository;
import com.lu.edu.interfaces.UserRepository;
import com.lu.edu.utils.result.CommonResult;
import com.querydsl.core.QueryResults;
import jakarta.persistence.criteria.CriteriaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2023/11/24 10:41
 **/

@RestController
public class DynamicQueryController {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private UserRepository userRepository;

    /** 
     * @Description: 
     * @Author: 雨同我
     * @DateTime: 2023/11/24 11:03
     * @param: null: 
     * @return:
     * SELECT * FROM `user` WHERE user_gender='MALE' GROUP BY username;
     * https://www.baeldung.com/hibernate-criteria-queries
    */

    @PostMapping("/dynamicQuery")
    public CommonResult dynamicQuery(@RequestBody UserDiyEntity userDto) {
        List<UserDiyEntity> all = userRepository.findAll(((root, query, criteriaBuilder) -> {
            query.groupBy(root.get("username"));
            return criteriaBuilder.equal(root.get("sex"),userDto.getSex());
        }));
        long count = userRepository.count();
        return CommonResult.success(all);
    }

}
