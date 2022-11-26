package socket_programming;

import java.io.Serializable;

// Person 객체를 네트워크로 전송하기 위해서는 직렬화가 필요하며
// 직렬화를 수행할 클래스는 선언부에 java.io.Serializable 인터페이스를 구현해야함
// (단, 추상메서드는 없으며 단순 마커(Marker)용도로 사용)
public class Ex4Person implements Serializable {
	private String name;
	private int age;
	private String jumin;
	
	public Ex4Person(String name, int age, String jumin) {
		super();
		this.name = name;
		this.age = age;
		this.jumin = jumin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getJumin() {
		return jumin;
	}

	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	
}
