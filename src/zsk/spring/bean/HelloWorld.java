package zsk.spring.bean;

public class HelloWorld {
	private String name;

	public void setName(String name) {
		this.name = name;
	}
	
	public void Hello(){
		System.out.println("name:" + name);
	}

	public HelloWorld() {
	}
	
}
