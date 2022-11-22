package collectionsFramework;

import java.util.Arrays;

public class deepToString {

	public static void main(String[] args) {
		/*
		 * toString()은 일차원 배열에만 사용 가능
		 * deepTo String()은 배열의 모든 요소를 재귀적으로 접근해서 문자열을 구성하므로 2차원뿐만 아니라 3차원 이상의 배열에도 동작
		 * 
		 * */
		
		int[] arr = {0, 1, 2, 3, 4};
		int[][] arr2D = {{11,12}, {21,22}};
		
		System.out.println(Arrays.toString(arr)); // [0, 1, 2, 3, 4]
		System.out.println(Arrays.deepToString(arr2D)); // [[11, 12], [21, 22]]
		
		
		
		
		
	}

}
