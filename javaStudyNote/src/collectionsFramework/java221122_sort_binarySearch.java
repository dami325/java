package collectionsFramework;

import java.util.Arrays;

public class java221122_sort_binarySearch {
	
	public static void main(String[] args) {
		
			/*	
			  	순차 검색(linear search)
			  	- 배열이 정렬되어 있을 필요 x 단, 시간이 많이 걸림
			  	
			  	이진 검색(binary search)
			  	- 배열의 검색할 범위를 반복적으로 절반씩 줄여가면서 검색, 검색속도가 상당히 빠름 큰 배열의 검색에 유리
			 
			 	배열의 정렬과 검색 - sort(), binarySearch()
			 	sort()는 배열을 정렬할떄
			 	
			 	
			 	binarySearch()는 배열에 저장된 요소를 검색할 때 사용
			 	=> 배열에서 지정된 값이 저장된 index를 찾아서 반환
			 	   단, 반드시 배열이 정렬된 상태여야 올바른 결과를 얻을 수 있음
			 	   검색한 값과 일치하는 요소들이 여러 개 있다면, 이 중에서 어떤 것의 위치가 반환될지는 알 수 없다.
			 	   
			 */
		int[] arr = {3, 2, 0, 1, 4};
		int index = Arrays.binarySearch(arr, 2);
		System.out.println(index); 						// -5
		
		Arrays.sort(arr); 								// 배열 arr을 정렬한다.
		System.out.println(Arrays.toString(arr)); 		// [0, 1, 2, 3, 4]
		index = Arrays.binarySearch(arr, 2);
		
		System.out.println(index); 						// 2
		
	}
}
