package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class withChar {
    public static void main(String[] args) {
        List<int[]> list = Arrays.asList(new Solution().solution("banana"));
        System.out.println(Arrays.deepToString(list.toArray()));

    }
}
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int i1 = s.lastIndexOf(s.charAt(i), i - 1);
            if(i1 < 0){
                answer[i] = i1;
            }else{
                answer[i] = i - i1;
            }
        }
        return answer;
    }

}