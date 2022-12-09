package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class maximum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 0, min = 0, num;
        for (int i = 0; i < n; i++) {
            num = sc.nextInt();
            if (max == 0) {
                max = num;
                min = num;
            }else if(max < num){
                max = num;
            }
            if (min > num) {
                min = num;
            }
        }
        System.out.println(min + " " + max);
    }

}
