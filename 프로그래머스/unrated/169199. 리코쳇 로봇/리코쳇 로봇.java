import java.util.*;

class Solution {
    static int N, M; // 가로, 세로
    static char[][] graph;
    static boolean[][] visited;
    static int goalX, goalY;
    static int answer; 
    
    public class Node {
        int x, y, cnt;
        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    
    public int solution(String[] board) {
        N = board.length;
        M = board[0].length();
        
        graph = new char[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            char[] temp = board[i].toCharArray();
            for (int j = 0; j < temp.length; j++) {
                if (temp[j] == 'G') {
                    goalX = i;
                    goalY = j;
                }
                graph[i][j] = temp[j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 'R') {
                    answer = bfs(i, j);   
                }
            }
        }
                
        return answer;
    }
    
    public int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 0));
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            
            if (node.x == goalX && node.y == goalY) {
                return node.cnt;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = node.x;
                int ny = node.y;
                
                
                while ((0 <= nx && nx < N && 0 <= ny && ny < M) &&
                    graph[nx][ny] != 'D') {
                    nx += dx[i];
                    ny += dy[i];
                }
                
                
                nx -= dx[i];
                ny -= dy[i];
                
                if (visited[nx][ny]) continue;

                queue.add(new Node(nx, ny, node.cnt + 1));
                visited[nx][ny] = true;
            }
        }
        
        return -1;
    }
}