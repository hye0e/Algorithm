import java.util.*;

class Solution {
    static Set<Integer> set = new HashSet<>();
    static boolean[] visited;
    static int N;
    
    public void dfs(String temp, int depth, String numbers) {
        if (N == depth) {
            set.add(Integer.parseInt(temp));
            return;
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (visited[i]) continue;
            visited[i] = true;
            if (!temp.equals("")) set.add(Integer.parseInt(temp));
            dfs(temp + numbers.charAt(i), depth + 1, numbers);
            visited[i] = false;
        }
    }
    
    public boolean isPrime(int x) {
        if (x < 2) return false;
        
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) return false; 
        }
        
        return true;
    }
    
    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];
        N = numbers.length();
        dfs("", 0, numbers);
        
        for (Integer num : set) {
            if (isPrime(num)) answer++;
        }
        
        return answer;
    }
}