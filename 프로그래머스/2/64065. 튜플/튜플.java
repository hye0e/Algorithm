import java.util.*;

class Solution {
    public List<Integer> solution(String s) {
        List<Integer> answer = new ArrayList<>();
        
        // 1. 맨앞에 있는 {{ 제거
        s = s.substring(2, s.length());
        
        // 2. 맨 뒤에 있는 }} 제거
        s = s.substring(0, s.length() - 2);
        
        s = s.replace("},{", "-");
        String[] arr = s.split("-");
        
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });
        
        
        // 3. 탐색
        for (String str : arr) {
            String[] temp = str.split(",");
            for (int i = 0; i < temp.length; i++) {
                int num = Integer.parseInt(temp[i]);
                if (!answer.contains(num)) {
                    answer.add(num);
                }
            }
        }
        
        System.out.println(answer);
        return answer;
    }
}