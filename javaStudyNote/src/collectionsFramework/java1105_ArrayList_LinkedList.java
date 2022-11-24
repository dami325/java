package collectionsFramework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class java1105_ArrayList_LinkedList {

	public static void main(String[] args) {
		
		ArrayList al = new ArrayList(1000000);
		LinkedList ll = new LinkedList();
		add(al);
		add(ll);
		
		System.out.println("= 접근시간테스트 =");
		System.out.println("ArrayList : " + access(al));
		System.out.println("LinkedList : " + access(ll));
		
		//두 클래스의 장점을 이용해 두 클래스를 조합해서 사용하는방법
//		ArrayList al = new ArrayList(1000000);
//		for(int i = 0; i < 100000; i++) {
//				al.add(i+"");
//		}
//		LinkedList ll = new LinkedList(al);
//		for(int i = 0; i < 1000; i++) {
//				ll.add(500, "X");
//		}
		
		
	}

	public static void add(List list) {
		for(int i = 0; i < 1000000; i++) {
			list.add(i+"");
		}
	}
	
	
	public static long access(List list) {
		long start = System.currentTimeMillis();
		for(int i = 0; i < 10000; i++) {
			list.get(i);
		}
		long end = System.currentTimeMillis();
		return end - start;
	}
	
	
}
