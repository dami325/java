package collectionsFramework;

import java.util.HashMap;
import java.util.Scanner;

public class _1126HashMapEx1 {

	public static void main(String[] args) {
		/*
			HashMap을 생성하고 사용자 ID와 
			비밀번호를 키와 값의 쌍(pair)으로 저장한 다음
			입력된 사용자ID를 키로 HashMap 에서 검색해서 얻은 값(비밀번호)을 
			입력된 비밀번호와 비교하는 예제
		*/
		HashMap map = new HashMap();
		map.put("myId", "1234");
		map.put("asdf", "1111");
		map.put("asdf", "1234");
		
		Scanner s = new Scanner(System.in);
		
		while(true) {
			System.out.println("id와 password를 입력해주세요.");
			System.out.println("id : ");
			String id = s.nextLine().trim();
			
			System.out.println("password : ");
			String password = s.nextLine().trim();
			System.out.println();
			
			if(!map.containsKey(id)) {
				System.out.println("입력하신 id는 존재하지 않습니다. 다시 입력해주세요.");
				continue;
			}
			
			if(!(map.get(id)).equals(password)){
				System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
			} else {
				System.out.println("id와 비밀번호가 일치합니다.");
				break;
			}
			
		}
		
	}

}
