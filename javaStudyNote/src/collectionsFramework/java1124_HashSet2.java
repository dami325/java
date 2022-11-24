package collectionsFramework;

import java.util.HashSet;
import java.util.Objects;


// HashSet 클래스의 작성의도대로 두 인스턴스를 같은 것으로 인식하게 하는 예제
public class java1124_HashSet2 {

	public static void main(String[] args) {
		HashSet set = new HashSet();
		
		set.add(new String("abc"));
		set.add(new String("abc"));
		set.add(new Person2("dami", 10));
		set.add(new Person2("dami", 10));
	
		
		
		System.out.println(set);
	}
}
		//HashSet의 add() 는 요소를 추가하기 전에 기존에 저장된 요소와 같은 것인지 판별하기 위해 
		// 추가하려는 요소의 equals()와 hashCode()를 호출하기 때문에 두 메서드를 목적에 맞게 오버라이딩
class Person2 {
	String name;
	int age;
	
	public Person2(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Person2) {
			Person2 tmp = (Person2) obj;
			return name.equals(tmp.name) && age==tmp.age;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
//		return (name+age).hashCode();
		// JDK1.8 부터 추가된 아래의 hash() 를 사용하는게 좋음
		return Objects.hash(name, age); // int hash(Object... values)
	}
	
	@Override
	public String toString() {
		return name +":"+ age;
	}
	
}