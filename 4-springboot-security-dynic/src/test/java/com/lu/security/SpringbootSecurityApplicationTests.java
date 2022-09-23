package com.lu.security;

import com.lu.security.entity.UmsMenu;
import com.lu.security.service.UmsRoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootSecurityApplicationTests {

    @Autowired
    private UmsRoleService umsRoleService;
    @Test
    void contextLoads() {
        List<UmsMenu> menuList = umsRoleService.getMenuList(5L);
        System.out.println(menuList);
    }

}
