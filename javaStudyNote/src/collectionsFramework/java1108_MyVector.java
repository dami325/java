package collectionsFramework;

import java.util.Iterator;

public class java1108_MyVector extends java1104_ArrayList2 implements Iterator {
	int cursor = 0; // 앞으로 읽어올 요소의 위치를 저장(index)
	int lastRet = -1; // 마지막으로 읽어온 요소의 위치를 저장(index)
	
	public java1108_MyVector(int capacity) {
		super(capacity);
	}
	
	public java1108_MyVector() {
		this(10);
	}
	
	public String toString() {
		String tmp = "";
		Iterator it = iterator();
		
		for(int i = 0; it.hasNext(); i++) {
			if(i !=0) tmp+=",";
			tmp += it.next(); //tmp += next().toString();
		}
		return "[" + tmp + "]";
	}
	
	public Iterator iterator() {
		cursor = 0; // cursor와 lastRet를 초기화한다.
		lastRet = -1;
		return this;
	}
	
	public boolean hasNext() {
		return cursor != size();
	}
	
	public Object next() {
		Object next = get(cursor);
		lastRet = cursor++;
		return next;
	}
	
	public void remove() {
		// 더 이상 삭제할 것이 없으면 IllegalStateException를 발생시킨다.
		if(lastRet == -1) {
			throw new IllegalStateException();
		}else {
			remove(lastRet);
			cursor--;		//삭제 후 커서의 위치를 감소
			lastRet = -1;	//lastRet의 값을 초기화
		}
	}
	
	
}
