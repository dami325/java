package collectionsFramework;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class java1124_HashSet_Lotto {

	public static void main(String[] args) {
		Object[] objArr = {"1", new Integer(1),"2","2","3","3","4","4","4"};
		Set set = new HashSet();
		
//		for(int i = 0; i < objArr.length; i++) {
//			set.add(objArr[i]);
//		}
//		
//		System.out.println(set); //[ 1, 1, 2, 3, 4 ]
		
		
		// 중복된 값은 저장되지 않는 HashSet의 성질을 이용해서 로또번호를 만드는 예제
		for(int i = 0; set.size() < 6 ; i++) {
			int num = (int)(Math.random()*45) + 1;
			set.add(new Integer(num));
		}
		
		// 번호를 크기순으로 정렬하기 위해서 Collections 클래스의 sort(List list) 사용
		List list = new LinkedList(set); // LinkedList(Collection c)
		Collections.sort(list);			 // Collections.sort(List list)
		System.out.println(list);
		
	}

}
