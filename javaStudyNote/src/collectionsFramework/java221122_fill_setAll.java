package collectionsFramework;

import java.util.Arrays;

public class java221122_fill_setAll {

	public static void main(String[] args) {
		
		/*
		  배열 채우기 - fill(), setAll()
		  fill() 은 배열의 모든 요소를 지정된 값으로 채운다.
		  setAll()은 배열을 채우는데 사용할 함수형 인터페이스를 매개변수로 받는다.
		 * */ 
		int[] arr = new int[5];
		Arrays.fill(arr, 5);
		for(int a : arr) {
			System.out.print(a);
		}
//			Arrays.setAll(arr, ()->(int)(Math.random()*5) + 1);
		
	}

}
