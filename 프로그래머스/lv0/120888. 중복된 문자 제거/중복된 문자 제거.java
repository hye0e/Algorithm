import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        char[] arr = my_string.toCharArray();
        List<Character> st = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (!st.contains(arr[i])) {
                answer += String.valueOf(arr[i]);
                st.add(arr[i]);
            }
        }
        
        System.out.println(st);
        return answer;
    }
}