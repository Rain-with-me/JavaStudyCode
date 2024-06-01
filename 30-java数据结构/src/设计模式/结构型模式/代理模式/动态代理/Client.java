package 设计模式.结构型模式.代理模式.动态代理;

public class Client {
	public static void main(String[] args) {
		//创建目标对象
		ITeacherDao target = new TeacherDao();

		//创建代理对象
		ITeacherDao proxyInstance = (ITeacherDao)new ProxyFactory(target).getProxyFactory();

		//内存中动态生成了代理对象
		System.out.println(proxyInstance.getClass());

		//通过代理对象，调用目标对象的方法
		proxyInstance.teach();
		proxyInstance.tesst("一键三连");
	}
}

