package 设计模式.结构型模式.代理模式.动态代理;

public class TeacherDao implements ITeacherDao {
	@Override
	public void teach() {
		System.out.println("一键三连");
	}
	@Override
	public void tesst(String name) {
		System.out.println("传参测试：" + name);
	}
}
