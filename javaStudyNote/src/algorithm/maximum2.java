package algorithm;

import java.util.Scanner;

public class maximum2 {
    public static void main(String[] args) {
        int answer = 0, count = 0, asCount = 0, num = 0;
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            num = s.nextInt();
            count++;
            if(answer < num){
                answer = num;
                asCount = count;
            }
        }
        System.out.println(answer);
        System.out.println(asCount);
    }
}
