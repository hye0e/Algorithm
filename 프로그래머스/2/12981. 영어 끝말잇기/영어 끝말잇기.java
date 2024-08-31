import java.util.*;

class Solution {
    static List<String> wordsSaid = new ArrayList<>();
    
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다. 
        int now = 1;
        
        wordsSaid.add(words[0]);
        char beforeWord = words[0].charAt(words[0].length() - 1);
        
        int[] order = new int[n];
        order[0] = 1;
        
        boolean success = true;
        for (int i = 1; i < words.length; i++) {        
            // 탈락
            if (wordsSaid.contains(words[i])) {
                success = false;
                break;
            }
            if (words[i].charAt(0) != beforeWord) {
                success = false;
                break;
            }
            
            wordsSaid.add(words[i]);
            order[now]++;
            now = (now + 1) % n;
            beforeWord = words[i].charAt(words[i].length() - 1);
        }
        
        if (success) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = now + 1;
            answer[1] = order[now] + 1;
        }
        return answer;
    }
}