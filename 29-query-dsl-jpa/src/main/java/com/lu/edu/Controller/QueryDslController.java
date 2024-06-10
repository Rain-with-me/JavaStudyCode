package com.lu.edu.Controller;

import com.lu.edu.entity.AdminEntity;
import com.lu.edu.entity.QAdminEntity;
import com.lu.edu.entity.vo.PageSizeVo;
import com.lu.edu.interfaces.AdminRepository;
import com.lu.edu.utils.result.CommonResult;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2023/11/10 14:45
 **/

@RestController
@Slf4j
public class QueryDslController {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    //    分页   跳过多少行。offset = ( pageNum - 1 ) * pageSize		// pageNum：第几页
    @PostMapping("/page")
    public CommonResult testSelectPage(@RequestBody PageSizeVo pageSizeVo) {
        QAdminEntity qAdminEntity = QAdminEntity.adminEntity;
        QueryResults<AdminEntity> fetchResults = jpaQueryFactory.selectFrom(qAdminEntity)
                .limit(3)
                .offset(1)
                .fetchResults();
        List<AdminEntity> list = fetchResults.getResults();
        log.info("总数{}",fetchResults.getTotal());
        return CommonResult.success(list);
    }

    @PostMapping("/insertAdmin")
    public CommonResult insertAdmin(@RequestBody AdminEntity adminEntity) {
        QAdminEntity qAdminEntity = QAdminEntity.adminEntity;
//        long execute = jpaQueryFactory.insert(qAdminEntity).values(adminEntity).execute();
        return CommonResult.success("成功");
    }

}
