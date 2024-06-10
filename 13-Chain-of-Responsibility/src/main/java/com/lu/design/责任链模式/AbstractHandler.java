package com.lu.design.责任链模式;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: 雨同我
 * @Description: 有一个指向责任下一个对象的属性
 *               一个设置下一个对象的set方法
 *               给子类对象差异化实现的方法（如以下代码的doFilter方法）
 * @DateTime: 2022/11/2 9:38
 **/

public abstract class AbstractHandler {

    private AbstractHandler nextHandler;
    // 设置下一个
    public void setNextHandler(AbstractHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    /**
     * @Description:  使用递归遍历全部
    */
    public void filter(HttpServletRequest request, HttpServletResponse response){
        doFiler(request,response);
        if (getNextHandler()!=null){
            getNextHandler().filter(request,response);
        }
    }

    public AbstractHandler getNextHandler(){
        return nextHandler;
    }

    protected abstract void doFiler(HttpServletRequest request, HttpServletResponse response);
}
