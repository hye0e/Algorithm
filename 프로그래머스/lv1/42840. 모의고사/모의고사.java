import java.util.*;

class Solution {
    public int[] solution(int[] answers) {        
        HashMap<Integer, Integer> board = new HashMap<>();
        
        int[] stu1 = new int[]{1, 2, 3, 4, 5};
        int[] stu2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] stu3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
                
        for (int i = 0; i < answers.length; i++) {
            if (stu1[i % stu1.length] == answers[i]) board.put(1, board.getOrDefault(1, 0) + 1);
            if (stu2[i % stu2.length] == answers[i]) board.put(2, board.getOrDefault(2, 0) + 1);
            if (stu3[i % stu3.length] == answers[i]) board.put(3, board.getOrDefault(3, 0) + 1);
        }
        
        int max = 0;
        for (Integer key : board.keySet()) {
            max = Math.max(max, board.get(key));
        }
        
        List<Integer> answer = new ArrayList<>();
        for (Integer key : board.keySet()) {
            if (max <= board.get(key)) answer.add(key);
        }
        
        return answer.stream().mapToInt(i -> i.intValue()).toArray();
    }
}