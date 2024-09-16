import java.util.*;

class Solution {
    static boolean[][] visited;
    static int n, m;
    static int[][] graph;
    public class Node {
        int x;
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        graph = new int[n][m];
       
        bfs(0, 0, maps);
        
        return graph[n - 1][m - 1] == 0 ? -1 : graph[n - 1][m - 1];
     }
    
    public void bfs(int x, int y, int[][] maps) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        visited[x][y] = true;
        graph[x][y] = 1;
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (visited[nx][ny]) continue;
                    if (maps[nx][ny] == 0) continue;
                    queue.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                    graph[nx][ny] = graph[node.x][node.y] + 1;
                }
            }
        }
        
    }
}