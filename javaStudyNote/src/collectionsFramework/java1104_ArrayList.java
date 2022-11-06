package collectionsFramework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class java1104_ArrayList {

	
	static void print(ArrayList list1, ArrayList list2) {
		System.out.println("list1:" + list1);
		System.out.println("list2:" + list2);
		System.out.println();
	}
	public static void main(String[] args) {
		//ArrayList의 기본적인 메서드를 이용해 객체를 다루는 방법
		ArrayList list1 = new ArrayList(10);
		list1.add(new Integer(5));
		list1.add(new Integer(4));
		list1.add(new Integer(2));
		list1.add(new Integer(0));
		list1.add(new Integer(1));
		list1.add(new Integer(3));
		
		ArrayList list2 = new ArrayList(list1.subList(1, 4)); // 1번째부터 4-1번째 인덱스 까지
		print(list1, list2);		//list1:[5, 4, 2, 0, 1, 3] list2:[4, 2, 0]
		
		Collections.sort(list1); 
		Collections.sort(list2); // 리스트 정렬
		print(list1, list2); 		//list1:[0, 1, 2, 3, 4, 5] list2:[0, 2, 4]
		
		System.out.println(list1.containsAll(list2)); // true (포함되었는지 확인)
		
		list2.add("B");
		list2.add("C");
		list2.add(3,"A"); // list2:[0, 2, 4, A, B, C]
		list2.set(3, "AA"); // list2:[0, 2, 4, AA, B, C]
		print(list1, list2);
				
		//1에서 2와 겹치는 부분만 남기고 나머지 삭제 removeAll과 반대개념 
		System.out.println(list1.retainAll(list2));
		print(list1, list2); // list1:[0, 2, 4] list2:[0, 2, 4, AA, B, C]
		
		for(int i = list2.size() -1; i >= 0; i--) {
			// 만일 변수 i를 증가시켜가면서 삭제하면, 한 요소가 삭제될 때마다 빈 공간을 채우기 위해 
			// 나머지 요소들이 자리이동을 하기 때문에 올바른 결과를 얻을수 없음
			// 제어변수를 감소시켜가면서 삭제를 해야 자리이동이 발생해도 영향을 받지 않고 작업 가능
			if(list1.contains(list2.get(i))) // 2가 1에 포함되어있으면 실행되는 if문
				list2.remove(i);
			
		}
		print(list1, list2); // list1:[0, 2, 4] list2:[AA, B, C]
		
		
		//-----------------------------------------------------------------------
		// 긴 문자열 데이터를 원하는 길이로 잘라서 ArrayList에 담은 다음 출력하는 예제
		// ArrayList를 생성할 때 저장할 요소의 개수를 고려해 실제 저장할 개수보다 약간 여유있는 크기로 하는 것이 좋다.
		// 자동적으로 크기가 늘어나긴 하지만 처리시간이 소요되기때문!
		final int LIMIT = 10; // 자르려는 글자의 개수를 지정
		String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()ZZZ";
		int length = source.length();
		
		List list = new ArrayList (length/LIMIT + 10); // 크기를 약간 여유 있게 잡는다.
		
		for(int i = 0; i < length; i += LIMIT) {
			if(i + LIMIT < length) {
				list.add(source.substring(i, i+LIMIT));
				System.out.println(list);
			} else {
				list.add(source.substring(i));
				System.out.println(list + " else");
			}
			
		}
			
		
		
	}

}
