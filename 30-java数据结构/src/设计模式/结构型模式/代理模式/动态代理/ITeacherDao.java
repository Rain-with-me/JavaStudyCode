package 设计模式.结构型模式.代理模式.动态代理;


/**
   * @description:	动态代理也叫JDK代理、接口代理。
 * 它使代理对象不需要实现接口（但目标对象要实现接口），
 * 代理对象的生成，是利用JDK的API，动态的在内存中构建代理对象。
   * @author: 鲁子哥的每一天
   * @time: 2022/4/22 20:21
 */


public interface ITeacherDao {
	void teach();
	void tesst(String name);
}
