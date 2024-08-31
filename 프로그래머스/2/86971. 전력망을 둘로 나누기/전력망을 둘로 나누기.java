import java.util.*;

class Solution {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    public int solution(int n, int[][] wires) {
        // 초기 세팅
        for (int i = 0; i < wires.length; i++) {
            bfs(i, n, wires);
        }
        
        
        return answer;
    }
    
    public static void bfs(int idx, int n, int[][] wires) {
        graph = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < wires.length; i++) {
            if (i == idx) continue; // 전력망 끊기
            
            int a = wires[i][0];
            int b = wires[i][1];
            
            graph.get(a - 1).add(b - 1);
            graph.get(b - 1).add(a - 1);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        
        visited = new boolean[n];
        visited[0] = true;
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            
            for (int node : graph.get(cur)) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.offer(node);
                }
            }
        }
        
        int one = 0, two = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) one++;
            else two++;
        }
        
        answer = Math.min(answer, Math.abs(one - two)); 
    }
}