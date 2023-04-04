import java.util.*;
class Solution {
    static int width, height;
    
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        // 1. 노란 격자 부터 구하기
        int yellowWidth = yellow;
        int yellowHeight = 1;
        for (int i = 1; i <= yellow; i++) {
            if (yellow % i != 0) continue;
            
            int tempHeight = i;
            int tempWidth = yellow / tempHeight;

            // 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
            if (tempWidth >= tempHeight) {
                if ((tempWidth + 2) * (tempHeight + 2) != (brown + yellow)) continue;
                yellowWidth = tempWidth;
                yellowHeight = tempHeight;
            } 
        }
        System.out.println("최종 yellowWidth: " + yellowWidth + "yellowHeight: " + yellowHeight);
        
        answer[0] = yellowWidth + 2;
        answer[1] = yellowHeight + 2;
        
        return answer;
    }
}