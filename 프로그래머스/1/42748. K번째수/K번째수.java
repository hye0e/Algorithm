import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int a_index = 0;
        for (int[] command : commands) {
            int start = command[0] - 1;
            int end = command[1];
            int[] newArr = new int[end - start];
            int index = 0;
            for (int i = start; i < end; i++) {
                newArr[index++] = array[i];
            }
            
            Arrays.sort(newArr);
            answer[a_index++] = newArr[command[2] - 1];
        }
        return answer;
    }
}