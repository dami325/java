package algorithm;

import java.util.Scanner;

public class factorial {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int total = factorial(sc.nextInt());
		System.out.println(total);
	}
	
	public static int factorial(int N) {
		
		if(N <= 0) return N + 1;
		
		return factorial(N-1) * N;
	}

}
