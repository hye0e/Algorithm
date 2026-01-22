import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split(" ");
        int[] numArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            numArr[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(numArr);
        sb.append(numArr[0] + " " + numArr[arr.length - 1]);
        System.out.println(Arrays.toString(numArr));
        return sb.toString();
    }
}