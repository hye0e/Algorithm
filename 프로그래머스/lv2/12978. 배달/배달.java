import java.util.*;
class Solution {    
    static class Node {
        int v; // 간선
        int cost; // 가중치
        
        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
    
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int[] dist;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        dist = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE; 
        }
        
        // 1. 양방향 그래프 만들기
        for (int i = 0; i < road.length; i++) {
            graph[road[i][0]].add(new Node(road[i][1], road[i][2]));
            graph[road[i][1]].add(new Node(road[i][0], road[i][2]));

        }
        
        // 2. 다익스트라 알고리즘 사용
        dijkstra(1);
        
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }
        return answer;
    }
    
    public void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        queue.add(new Node(start, 0));
        dist[start] = 0;
        
        while (!queue.isEmpty()) {
            // 현재 가장 짧은 노드를 꺼내서 방문처리                 
            Node now = queue.poll();
            
            if (!visited[now.v]) {
                visited[now.v] = true;
            }
            
            for (Node next: graph[now.v]) {
                if (!visited[next.v] && dist[next.v] > now.cost + next.cost) {
                    dist[next.v] = now.cost + next.cost;
                    queue.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }
}