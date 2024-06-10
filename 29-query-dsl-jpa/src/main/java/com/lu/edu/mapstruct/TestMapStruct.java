package com.lu.edu.mapstruct;

import com.lu.edu.mapstruct.mapper.IPersonMapper;

import java.util.Date;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2023/11/29 14:35
 **/

public class TestMapStruct {

    public static void main(String[] args) {
        System.out.println("-----------testNormal-----start------");
        UserEntity userPo = UserEntity.builder()
                .id(1L)
                .gmtCreate(new Date())
                .buyerId(666L)
                .userNick("测试mapstruct")
                .userVerified("ok")
                .age(18L)
                .build();
        System.out.println(userPo);
        UserVo userVo = IPersonMapper.INSTANCT.parseUserVo(userPo);
        UserEntity userEntity = IPersonMapper.INSTANCT.parseEntity(userVo);
        System.out.println(userVo);
        System.out.println(userEntity);

        UserDto user = UserDto.builder()
                .id(1L)
                .gmtCreate(new Date())
                .buyerId(666L)
                .username("测试mapstruct")
//                .userVerified("ok")
                .age(18L)
                .build();
        UserEntity parseEntity = IPersonMapper.INSTANCT.diyParseEntity(user);
        System.out.println(parseEntity);
        System.out.println("-----------testNormal-----ent------");
    }
}
