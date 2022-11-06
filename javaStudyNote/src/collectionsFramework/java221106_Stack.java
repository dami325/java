package collectionsFramework;

import java.util.EmptyStackException;
import java.util.Vector;

//Stack은 컬렉션 프레임웤 이전부터 존재하던 것이기 때문에 Vector 상속
public class java221106_Stack extends Vector { 
	
	public Object push(Object item) {
		addElement(item);
		return item;
	}
	
	public Object pop() {
		Object obj = peek(); // Stack에 저장된 마지막 요소를 읽어온다.
							 // Stack이 비었으면 EmptyStackException 발생
		removeElementAt(size() - 1); // 마지막 요소 삭제. 배열의 인덱스가 0부터 시작하므로 1을 빼줌
		return obj;
	}
	
	
	public Object peek() {
		int len = size();
		
		if(len ==0) {
			throw new EmptyStackException();
		}
		return elementAt(len); // 마지막 요소 반환. 배열의 인덱스가 0부터 시작하므로 1을 빼줌
	}
	
	public boolean empty() {
		return size() == 0;
	}
	
	public int search(Object o) {
		int i = lastIndexOf(o); 	// 끝에서부터 객체를 찾는다.
									// 반ㅇ환값은 저장된 위치(배열의 index) 이다.
		if(i >= 0) { // 객체를 찾은경우
			return size() - i; // Stack은 맨 위에 저장된 객체의 index를 1로 정의하기 때문에 계산을 통해서 구한다
		}
		return - 1; // 해당 객체를 찾지 못하면 -1 반환
	}
}
