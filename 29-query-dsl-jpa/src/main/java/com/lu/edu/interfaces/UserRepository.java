package com.lu.edu.interfaces;

import com.lu.edu.entity.UserDiyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2023/11/22 11:26
 **/
public interface UserRepository extends JpaRepository<UserDiyEntity,String>, JpaSpecificationExecutor<UserDiyEntity>, CrudRepository<UserDiyEntity,String> {
}
