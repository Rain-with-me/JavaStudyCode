package com.lu.factory.service.impl;

import com.lu.factory.service.IFileResolveFactory;

class DefaultFileResolve implements IFileResolveFactory {
   public void resolve(){
      System.out.println("默认文件类型解析");
   }
}