package polymorphism3;

public class BeanFactory {
	
	public Object getBean(String id) {
		if(id.equals("lg")) {
			return new LgTV();
		} else if (id.equals("samsung")) {
			return new SamsungTV();
		} else if (id.equals("sony")) {
			return new SonyTV();
		}
		return null;
	}

}
