package com.lu.factory.service.impl;

import com.lu.factory.service.IFileResolveFactory;

class BFileResolve implements IFileResolveFactory {
   public void resolve(){
      System.out.println("文件B类型解析");
   }
}