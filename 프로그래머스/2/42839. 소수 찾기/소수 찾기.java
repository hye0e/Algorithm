import java.util.*;

class Solution {
    static int N;
    static String[] numArr;
    static int answer = 0;
    static Set<Integer> set = new HashSet<>();
    static boolean[] visited;
    
    public void dfs(int depth, String num) {
        if (depth == N) {
            set.add(Integer.parseInt(num));
            return;
        }
        
        for (int i = 0; i < numArr.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            if (!num.equals("")) set.add(Integer.parseInt(num));
            dfs(depth + 1, num + numArr[i]);
            visited[i] = false;
        }
    }
    
    public boolean isPrime(int num) {        
        if (num < 2) return false;
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        
        return true;
    }
    public int solution(String numbers) {
        N = numbers.length();
        numArr = numbers.split("");
        visited = new boolean[N];
        dfs(0, "");
        
        for (int num : set) {
            if(isPrime(num)) answer++;
            System.out.println(num);
        }
        return answer;
    }
}