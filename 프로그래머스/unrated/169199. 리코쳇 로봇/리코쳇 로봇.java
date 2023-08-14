import java.util.*;

class Solution {
    int N, M;
    char[][] graph;
    boolean[][] visited;
    
    char GOAL = 'G';
    char START = 'R';
    char DISABLE = 'D';
    
    int answer;
    
    class Node {
        int x, y, depth;
        public Node(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
    
    public int solution(String[] board) {
        // 1. bfs 활용
        // 2. 게임판 위의 장애물이나 맨 끝에 부딪힐 때까지 미끄러져 이동하는 것 -> while
        N = board.length;
        M = board[0].length();
        graph = new char[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < board.length; i++) {
           char[] temp = board[i].toCharArray();
           graph[i] = temp;
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == START) answer = bfs(i, j);
            }
        }
        
        // System.out.println(Arrays.deepToString(graph));
        return answer;
    }
    
    public int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        queue.add(new Node(x, y, 0));
        visited[x][y] = true;
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (graph[node.x][node.y] == GOAL) return node.depth;
            
            for (int i = 0; i < 4; i++) {
                int nx = node.x;
                int ny = node.y;

//                 if (visited[nx][ny]) continue;

                while (isRange(nx, ny) && graph[nx][ny] != DISABLE) {
                    nx += dx[i];
                    ny += dy[i];    
                } 
                
                nx -= dx[i];
                ny -= dy[i];
                
                if (visited[nx][ny]) continue;
                
                queue.add(new Node(nx, ny, node.depth + 1));
                visited[nx][ny] = true;
            }
        }
        
        return -1;
    }
    
    public boolean isRange(int x, int y) {
        if (0 <= x && x < N && 0 <= y && y < M) return true;
        return false;
    }
}