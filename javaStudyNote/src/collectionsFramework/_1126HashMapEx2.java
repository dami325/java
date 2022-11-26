package collectionsFramework;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;



// 	HashMap의 기본적인 메서드를 이용해서 데이터를 저장하고 읽어오는 간단한 예제

public class _1126HashMapEx2 {

	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("김다미", new Integer(100));
		map.put("박다미", new Integer(100));
		map.put("서다미", new Integer(80));
		map.put("이다미", new Integer(90));
		
		Set set = map.entrySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();
			System.out.println("이름 : " + e.getKey() + ", 점수 : " + e.getValue());
		}
		set = map.keySet();
		System.out.println("참가자 명단 : " + set);
		
		Collection values = map.values();
		it = values.iterator();
		
		int total = 0;
		
		while(it.hasNext()) {
			Integer i = (Integer) it.next();
			total += i.intValue();
		}
		
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + (float) total/set.size());
		System.out.println("최고점수 : " + Collections.max(values));
		System.out.println("최저점수 : " + Collections.min(values));
		
		
		
		
	}

}
