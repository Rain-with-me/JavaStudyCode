package com.lu.template.service;

import org.springframework.beans.factory.annotation.Value;

/** 
 * @Description: 可用 final最终修饰模板方法以防止子类对其进行重写。
 * @Author: 雨同我
 * @DateTime: 2022/11/10 16:02
*/


public abstract class AbstractMerchantService {

    @Value("${server.port}")
    private static String port;

     //模板方法流程
     public final void handlerTempPlate(){
           //查询商户信息
           queryMerchantInfo();
           //加签
           signature();
           //http 请求
           httpRequest();
           // 验签
           verifySinature();
     }

    private void verifySinature() {
         port= String.valueOf(8020);
        System.out.println("=========验收======="+port);
    }

    private void httpRequest() {
        System.out.println("=========http 请求===========");
    }

    private void signature() {
        System.out.println("=========加签===========");
    }

    private void queryMerchantInfo() {
        System.out.println("=========查询===========");
    }

    // Http是否走代理（提供给子类实现）
    public abstract boolean isRequestByProxy();
}
