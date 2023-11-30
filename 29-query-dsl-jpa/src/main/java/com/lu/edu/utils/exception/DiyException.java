package com.lu.edu.utils.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class DiyException extends RuntimeException{

   private Integer code; //状态码
   private String msg;//异常信息
}
