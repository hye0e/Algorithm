import java.util.*;

class Solution {
    public List<Integer> solution(String s) {
        //1. 문자열을 배열로 변경
        //2. 문자길이대로 정렬
        //3. 하나씩 배열에 넣어보기
        List<String[]> tuple = toConvert(s);
        Collections.sort(tuple, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1.length - o2.length;
            }
        });
        
        int index = 0;
        
        List<Integer> answer = new ArrayList<>();
        for (String[] str : tuple) {
            for (int i = 0; i < str.length; i++) {
                int num = Integer.parseInt(str[i]);
                if (!answer.contains(num)) answer.add(num);
                else continue;
            }
        }
        
        return answer;
    }
    
    public List<String[]> toConvert(String s) {
        String temp = s.substring(2, s.length() - 2);
        String temp2 = temp.replace("},{","/");
        String[] temp3 = temp2.split("/");
        
        List<String[]> tuple = new ArrayList<>();
        
        for (String str : temp3) {
            String[] temp4 = str.split(",");
            tuple.add(temp4);
        }
        
        return tuple;
    }
}