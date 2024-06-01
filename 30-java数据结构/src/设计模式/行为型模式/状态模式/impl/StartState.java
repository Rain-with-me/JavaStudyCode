package 设计模式.行为型模式.状态模式.impl;

import 设计模式.行为型模式.状态模式.Context;
import 设计模式.行为型模式.状态模式.StateTemplate;

public class StartState implements StateTemplate {
 
   @Override
   public void doAction(Context context) {
      System.out.println("Player is in start state");
      context.setState(this); 
   }
 
   @Override
   public String toString(){
      return "Start State";
   }


}