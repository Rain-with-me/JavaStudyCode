package com.lu;

import com.lu.service.UmsAdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringsecurityJwtApplicationTests {

    @Autowired
    UmsAdminService umsAdminService;

    @Test
    public void contextLoads() {
        System.out.println(umsAdminService.getAdminByUsername("admin"));
    }

}
