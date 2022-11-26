package collectionsFramework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 	HashMap은 데이터의 키와 값을 모두 Object 타입으로 저장하기 때문에 
 	HashMap의 값(value)으로 HashMap을 다시 저장 할 수 있다.
 	하나의 키에 다시 복수의 데이터를 저장 가능
 	
 	*배열의 배열인 이차원 배열과 비교시 이해 쉬움
 */
public class _1127HashMapEx3 {
	static HashMap phoneBook = new HashMap();
	
	public static void main(String[] args) {
		addPhoneNo("친구", "다미", "010-111-1111");
		addPhoneNo("친구", "가미", "010-222-1111");
		addPhoneNo("친구", "나미", "010-333-1111");
		addPhoneNo("회사", "라미", "010-444-1111");
		addPhoneNo("회사", "마미", "010-555-1111");
		addPhoneNo("회사", "바미", "010-666-1111");
		addPhoneNo("회사", "사미", "010-777-1111");
		addPhoneNo("세탁소", "010-888-1111");
		
		printList();
	}
	
	// 전화번호부 전체를 출력하는 메서드
	private static void printList() {
		Set set = phoneBook.entrySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();
			
			Set subSet = ((HashMap)e.getValue()).entrySet();
			Iterator subIt = subSet.iterator();
			
			System.out.println(e.getKey()+ " " + subSet.size() + " ");
			
			while(subIt.hasNext()) {
				Map.Entry subE = (Map.Entry) subIt.next();
				String telNo = (String) subE.getKey();
				String name = (String) subE.getValue();
				System.out.println(name + " " + telNo);
			}
			System.out.println();
			
		}
	}

	// 그룹에 전화번호를 추가하는 메서드
	private static void addPhoneNo(String groupName, String name, String tel) {
		addGroup(groupName);
		HashMap group = (HashMap) phoneBook.get(groupName);
		group.put(tel, name);
	}

	// 그룹에 전화번호를 추가하는 메서드 그룹명 미작성시 기타
	private static void addPhoneNo(String name, String tel) {
		addPhoneNo("기타", name, tel);
	}

	private static void addGroup(String groupName) {
		if(!phoneBook.containsKey(groupName)) {
			phoneBook.put(groupName, new HashMap());
		}
	}

}
