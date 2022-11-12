# Getting Started

## 使用
- 一般和工厂模式配合使用，如果不会工厂模式，可以去瞅瞅

## 业务场景
假设有这样的业务场景，大数据系统把文件推送过来，根据不同类型采取不同的解析方式。多数的小伙伴就会写出以下的代码：
```
if(type=="A"){
//按照A格式解析

}else if(type=="B"){
//按B格式解析
}else{
//按照默认格式解析
}
```

这个代码可能会存在哪些问题呢？

如果分支变多，这里的代码就会变得臃肿，难以维护，可读性低。
如果你需要接入一种新的解析类型，那只能在原有代码上修改。

说得专业一点的话，就是以上代码，违背了面向对象编程的开闭原则以及单一原则。

开闭原则（对于扩展是开放的，但是对于修改是封闭的）：增加或者删除某个逻辑，都需要修改到原来代码
单一原则（规定一个类应该只有一个发生变化的原因）：修改任何类型的分支逻辑代码，都需要改动当前类的代码。

如果你的代码就是酱紫：有多个if...else等条件分支，并且每个条件分支，可以封装起来替换的，我们就可以使用策略模式来优化。

## 策略模式定义
策略模式定义了算法族，分别封装起来，让它们之间可以相互替换，此模式让算法的变化独立于使用算法的的客户。这个策略模式的定义是不是有点抽象呢？那我们来看点通俗易懂的比喻：

假设你跟不同性格类型的小姐姐约会，要用不同的策略，有的请电影比较好，有的则去吃小吃效果不错，有的去逛街买买买最合适。当然，目的都是为了得到小姐姐的芳心，请看电影、吃小吃、逛街就是不同的策略。

策略模式针对一组算法，将每一个算法封装到具有共同接口的独立的类中，从而使得它们可以相互替换。