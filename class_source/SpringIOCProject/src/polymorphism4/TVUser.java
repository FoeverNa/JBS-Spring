package polymorphism4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		
		// 1. ������ IoC(Inversion of Control) �����̳ʸ� ����(����)�Ѵ�.
		GenericXmlApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
//		BeanFactory factory = new BeanFactory();

		// 2. ������ Ioc �����̳ʷκ��� ��ü�� �˻�(Lookup)�Ѵ�. 
				
		TV tv = (TV) container.getBean("tv");
//		TV tv2 = (TV) container.getBean("tv");
//		TV tv3 = (TV) container.getBean("tv");
//		System.out.println(tv1.toString());
//		System.out.println(tv2.toString());
//		System.out.println(tv3.toString());
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		// 3. ������ IoC �����̳ʸ� �����Ѵ�.(�����̳ʴ� ����Ǳ� ������ �ڽ��� �����ϴ� ��� ��ü�� �����Ѵ�.)
		container.close();
	}
}
