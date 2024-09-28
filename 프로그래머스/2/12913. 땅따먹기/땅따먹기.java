import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        for (int i = 1; i < land.length; i++) {
            land[i][0] += Math.max(land[i - 1][1], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][1] += Math.max(land[i - 1][0], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][2] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][3]));
            land[i][3] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][2]));
        }
        
        Arrays.sort(land[land.length - 1]);
        
        // System.out.println(Arrays.toString(land[land.length - 1]));
        return land[land.length - 1][3];
    }
}