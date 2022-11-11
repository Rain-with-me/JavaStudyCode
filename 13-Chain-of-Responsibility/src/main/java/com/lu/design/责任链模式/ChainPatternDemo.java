package com.lu.design.责任链模式;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Component
public class ChainPatternDemo {

    //自动注入各个责任链的对象
    @Autowired
    private List<AbstractHandler> abstractHandleList;

    private AbstractHandler abstractHandler;

    //spring注入后自动执行，责任链的对象连接起来
    @PostConstruct
    public void initializeChainFilter(){
        System.out.println("实现类的大小----"+abstractHandleList.size());
        for(int i = 0;i<abstractHandleList.size();i++){
            if(i == 0){
                abstractHandler = abstractHandleList.get(0);
            }else{
                AbstractHandler currentHander = abstractHandleList.get(i-1);
                AbstractHandler nextHander = abstractHandleList.get(i);
                currentHander.setNextHandler(nextHander);
            }
        }
    }

    //直接调用这个方法使用
    public HttpServletResponse exec(HttpServletRequest request, HttpServletResponse response) {
        abstractHandler.filter(request, response);
        return response;
    }

    public AbstractHandler getAbstractHandler() {
        return abstractHandler;
    }

    public void setAbstractHandler(AbstractHandler abstractHandler) {
        this.abstractHandler = abstractHandler;
    }
}