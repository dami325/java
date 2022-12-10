package algorithm;

import java.util.Scanner;

public class blackJack {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int M = s.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = s.nextInt();
        }

        int result = total(nums,N,M);
        System.out.println(result);
    }

    private static int total(int[] nums, int n, int m) {
        int result = 0;
        //첫 번째 카드 시작
        for (int i = 0; i < n - 2; i++) {
            //두 번째 카드 시작
            for (int j = i + 1; j < n - 1; j++) {
                //세 번째 카드 시작
                for (int k = j + 1; k < n; k++) {
                    int total = nums[i] + nums[j] + nums[k];

                    if (total == m) {
                        return total;
                    }
                    if (total < m && result < total) {
                        result = total;
                    }
                }
            }
        }
        return result;
    }

}
