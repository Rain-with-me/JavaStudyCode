package com.lu.edu.mapstruct.mapper;

import com.lu.edu.mapstruct.UserDto;
import com.lu.edu.mapstruct.UserEntity;
import com.lu.edu.mapstruct.UserVo;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-29T15:22:19+0800",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class IPersonMapperImpl implements IPersonMapper {

    @Override
    public UserEntity parseEntity(UserVo userVo) {
        if ( userVo == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.id( userVo.getId() );
        userEntity.gmtCreate( userVo.getGmtCreate() );
        userEntity.createTime( userVo.getCreateTime() );
        userEntity.buyerId( userVo.getBuyerId() );
        userEntity.age( userVo.getAge() );
        userEntity.userNick( userVo.getUserNick() );
        userEntity.userVerified( userVo.getUserVerified() );

        return userEntity.build();
    }

    @Override
    public UserVo parseUserVo(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserVo.UserVoBuilder userVo = UserVo.builder();

        userVo.id( userEntity.getId() );
        userVo.gmtCreate( userEntity.getGmtCreate() );
        userVo.createTime( userEntity.getCreateTime() );
        userVo.buyerId( userEntity.getBuyerId() );
        userVo.age( userEntity.getAge() );
        userVo.userNick( userEntity.getUserNick() );
        userVo.userVerified( userEntity.getUserVerified() );

        return userVo.build();
    }

    @Override
    public UserEntity diyParseEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.userNick( userDto.getUsername() );
        userEntity.createTime( userDto.getCreateTime() );
        userEntity.age( userDto.getAge() );
        if ( userDto.getUserVerified() != null ) {
            userEntity.userVerified( userDto.getUserVerified() );
        }
        else {
            userEntity.userVerified( "成功" );
        }
        userEntity.gmtCreate( userDto.getGmtCreate() );
        userEntity.buyerId( userDto.getBuyerId() );

        return userEntity.build();
    }
}
