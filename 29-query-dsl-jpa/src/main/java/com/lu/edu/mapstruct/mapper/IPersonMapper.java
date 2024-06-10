package com.lu.edu.mapstruct.mapper;

import com.lu.edu.mapstruct.UserDto;
import com.lu.edu.mapstruct.UserEntity;
import com.lu.edu.mapstruct.UserVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IPersonMapper {
    IPersonMapper INSTANCT = Mappers.getMapper(IPersonMapper.class);
    UserEntity parseEntity(UserVo userVo);
    UserVo parseUserVo(UserEntity userEntity);


    @Mapping(target = "userNick", source = "username")
    @Mapping(target = "createTime", source = "createTime", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "age", source = "age", numberFormat = "#0.00")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userVerified", defaultValue = "成功")
    UserEntity diyParseEntity(UserDto userDto);
}
