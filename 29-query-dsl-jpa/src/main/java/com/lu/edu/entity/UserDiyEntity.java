package com.lu.edu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lu.edu.config.ValiteGroup;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2023/11/21 15:47
 **/

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "user",schema = "books")
public class UserDiyEntity {
//    主键
    @Id
    @GeneratedValue(generator = "custom-id")
    @GenericGenerator(name = "custom-id", strategy = "com.lu.edu.config.CustomIdGenerator")
    @Column(length = 20)
    private String id;

//    普通字段 【unique 唯一字段】【name= 数据库字段】
    @Column(length = 30,unique = true)
    @NotBlank(groups = ValiteGroup.Crud.Create.class,message = "名字为必填项")
    private String username;

//    【ORDINAL是数字】
    @Enumerated(EnumType.STRING)
    @Column(name = "user_gender")
    private Gender sex;

//    【关联关系，一对多】
    @OneToMany(mappedBy = "userDiy",cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<GroupDiyEntity> groupDiys;

    @Email(message = "请填写正取的邮箱地址")
    private String email;

    public enum Gender{
        MALE("男"),
        FEMALE("女");
        public String value;
        Gender(String value){
            this.value=value;
        }
    }
}
