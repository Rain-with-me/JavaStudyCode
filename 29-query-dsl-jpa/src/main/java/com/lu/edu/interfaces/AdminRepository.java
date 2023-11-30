package com.lu.edu.interfaces;

import com.lu.edu.entity.AdminEntity;
import com.lu.edu.violate.EnumString;
import com.lu.edu.violate.Role;
import com.lu.edu.violate.Roles;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2023/11/13 9:42
 **/

/**
 * @Description:
 * @Author: 雨同我
 * @DateTime: 2023/11/17 15:01
 * @param: null:
 * @return: sql关键字对应
 * ttps://docs.spring.io/spring-data/data-jpa/docs/current/reference/html/#jpa.sample-app.finders.strategies
 */


//@Roles(rolesName = {@Role(roleName = "admin"), @Role(roleName = "user")})
public interface AdminRepository extends JpaRepository<AdminEntity,Long>, JpaSpecificationExecutor<AdminEntity> {
    @Query("select u from AdminEntity u where u.username = ?1")
    List<AdminEntity> findByName(String username);

//    @Query("select u from AdminEntity u where u.username = :username")
//    List<AdminEntity> findByName(@Param("username") String username);

    @Query(value = "SELECT u FROM AdminEntity u WHERE u.name IN :names")
    List<AdminEntity> findUserByNameList(@Param("names") Collection<String> names);

    //    https://www.baeldung.com/spring-data-jpa-query  【更新添加@Modifying】
    @Transactional
    @Modifying
    @Query("update AdminEntity u set u.status = :#{#adminEntity.status} where u.username=:#{#adminEntity.username}")
    int updateByName(@Param("adminEntity") AdminEntity adminEntity);

    //    TODO 优化为对象参数
    @Transactional
    @Modifying
    @Query("insert INTO AdminEntity (username, email, status) VALUES (:#{#adminEntity.username}, :#{#adminEntity.email}, :#{#adminEntity.status})")
    int insertAdmin(@Param("adminEntity") AdminEntity adminEntity);

}
