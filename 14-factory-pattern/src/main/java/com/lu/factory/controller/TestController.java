package com.lu.factory.controller;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2022/11/10 11:11
 **/

/**
 * @Description: 使用，下面不会出现，具体使用看看我在策略模式的使用，他使用了spring的特性，搞了一个工程模式
 *  IFileStrategy getFileStrategy(FileTypeResolveEnum fileType){
 *      IFileStrategy  fileStrategy ;
 *      if(fileType=FileTypeResolveEnum.File_A_RESOLVE){
 *        fileStrategy = new AFileResolve();
 *      }else if(fileType=FileTypeResolveEnum.File_A_RESOLV){
 *        fileStrategy = new BFileResolve();
 *      }else{
 *        fileStrategy = new DefaultFileResolve();
 *      }
 *      return fileStrategy;
 *  }
*/

public class TestController {
}
