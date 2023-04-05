import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            int cnt = commands[i][1] - commands[i][0] + 1;
            int[] firstArr = new int[cnt];
            int index = 0;
            for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
                firstArr[index] = array[j];
                index++;
            }
            Arrays.sort(firstArr);
            System.out.println(Arrays.toString(firstArr));
            answer[i] = firstArr[commands[i][2] - 1];
        }
        return answer;
    }
}