import java.util.*;

class Solution {
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static boolean[][] visited;
    static int N;
    static int M;
    
    public class Node {
        int x;
        int y;
        int cnt;
        
        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    public int solution(int[][] maps) {
        int start_x = 0;
        int start_y = 0;
        
        N = maps.length;
        M = maps[0].length;
        visited = new boolean[N][M];
        
        int answer = bfs(start_x, start_y, maps);
        if (!visited[N - 1][M - 1]) return -1;
        return answer;
    }
    
    public int bfs(int start_x, int start_y, int[][] maps) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start_x, start_y, 1));
        visited[start_x][start_y] = true;
        int total = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            int cnt = node.cnt;
            
            // 목표 지점에 도달한 경우 해당 거리 반환
            if (x == N - 1 && y == M - 1) {
                return cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (visited[nx][ny]) continue;
                    if (maps[nx][ny] == 0) continue;
                    
                    visited[nx][ny] = true;
                    queue.add(new Node(nx, ny, cnt + 1));
                }
            }
        }
        
        return -1;
    }
}