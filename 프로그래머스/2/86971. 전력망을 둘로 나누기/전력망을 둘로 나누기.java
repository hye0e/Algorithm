import java.util.*;

class Solution {
    static List<Integer>[] graph;
    static int answer = Integer.MAX_VALUE;
    public int solution(int n, int[][] wires) {  
        graph = new ArrayList[n + 1];
        for (int i = 0; i < n; i++) {
            bfs(i, n, wires);
        }
        return answer;
    }
    
    public void bfs(int cut, int n, int[][] wires) {
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < wires.length; i++) {
            if (i  == cut) continue;
            
            int node = wires[i][0];
            int vertex = wires[i][1];
            
            graph[node].add(vertex);
            graph[vertex].add(node);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        queue.add(1);
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int node : graph[cur]) {
                if (visited[node]) continue;
                visited[node] = true;
                queue.offer(node);
            }
        }
        
         int one = 0, two = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i]) one++;
            else two++;
        }
        
        answer = Math.min(answer, Math.abs(one - two)); 
    }
}