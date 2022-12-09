package algorithm;

import java.util.Scanner;

public class matrix {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int M = s.nextInt();
        int[][] matrix = new int[N][M];
        int number = 0;

        for (int k = 0; k < 2; k++){
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    number = s.nextInt();
                    matrix[i][j] += number;
                }
            }
        }

        for(int[] i : matrix){
            for(int j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }



    }
}
