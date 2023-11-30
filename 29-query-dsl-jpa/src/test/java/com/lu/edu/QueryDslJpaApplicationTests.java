package com.lu.edu;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.lu.edu.entity.AdminEntity;
import com.lu.edu.entity.QAdminEntity;
import com.lu.edu.mapstruct.UserEntity;
import com.lu.edu.mapstruct.UserVo;
import com.lu.edu.mapstruct.mapper.IPersonMapper;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryFactory;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static com.mysema.commons.lang.Assert.assertThat;

@SpringBootTest
class QueryDslJpaApplicationTests {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    /** 
     * @Description: 更新操作
     * @Author: 雨同我
     * @DateTime: 2023/11/10 11:31
     * @param: null: 
     * @return: 
    */

    @Test
    @Transactional
    public void testUpdate() {
        QAdminEntity adminEntity = QAdminEntity.adminEntity;
        Long result = jpaQueryFactory.update(adminEntity)
                .set(adminEntity.name, "haha")		// 可以用if条件判断更新值来确定字段是否.set()
                .setNull(adminEntity.times)       // 设置null值
                .where(adminEntity.aid.eq(10001)).execute();
        System.out.println("result===>"+result);
    }

    /**
     * @Description: 查询操作
     * @Author: 雨同我
     * @DateTime: 2023/11/10 11:34
     * @param: null:
     * @return:
    */
    @Test
    void testSelect() {
        QAdminEntity qAdminEntity = QAdminEntity.adminEntity;
        List<AdminEntity> adminEntitiesList = jpaQueryFactory.selectFrom(qAdminEntity)
                .fetch();
        System.err.println("====================");
        adminEntitiesList.forEach(k->{
            System.out.println(k.getAid()+" "+k.getName());
        });
        var aid=10001;
        List<AdminEntity> whereEntities = jpaQueryFactory.selectFrom(qAdminEntity)
                .where(qAdminEntity.aid.eq(aid).and(qAdminEntity.username.contains("admin")))
                .fetch();

    }
//    分页
    @Test
    void testSelectPage() {
        QAdminEntity qAdminEntity = QAdminEntity.adminEntity;
        QueryResults<AdminEntity> fetchResults = jpaQueryFactory.selectFrom(qAdminEntity)
                .limit(3)
                .offset(1)
                .fetchResults();
        List<AdminEntity> list = fetchResults.getResults();

        System.err.println("====================");
    }

    @Test
    void testUuid() {
        Snowflake snowflake = IdUtil.getSnowflake();
        String s = snowflake.nextIdStr();
        System.out.println(s);
        System.err.println("====================");
    }


    @Test
    void testDynamic() {
        String s="123";

    }



    @Test
    void contextLoads() {
        System.out.println(IdUtil.fastSimpleUUID());
    }

    @Test
    void testMapstruct(){
        System.out.println("-----------testNormal-----start------");
        UserVo userPo = UserVo.builder()
                .id(1L)
                .gmtCreate(new Date())
                .buyerId(666L)
                .userNick("测试mapstruct")
                .userVerified("ok")
                .age(18L)
                .build();
        System.out.println(userPo);
        UserEntity userEntity = IPersonMapper.INSTANCT.parseEntity(userPo);
        System.out.println(userEntity);
        System.out.println("-----------testNormal-----ent------");
    }

}
