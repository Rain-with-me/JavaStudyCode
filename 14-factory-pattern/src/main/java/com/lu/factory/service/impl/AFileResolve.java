package com.lu.factory.service.impl;

import com.lu.factory.service.IFileResolveFactory;

class AFileResolve implements IFileResolveFactory {
   public void resolve(){
      System.out.println("文件A类型解析");
   }
}