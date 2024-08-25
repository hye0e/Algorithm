import java.util.*;
import java.io.*;

class Solution {
    static int n, m;
    static boolean[][] visited;
    static int[] count;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static int answer;
    
    public static class Node {
        int x;
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        count = new int[m];
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, land);
                }
            }
        }
        
        return answer;
    }
    
    public static void bfs(int x, int y, int[][] land) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        visited[x][y] = true;
        
        Set<Integer> sichu = new HashSet<Integer>();
        sichu.add(y);
        int cnt = 1;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            sichu.add(node.y);
            
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (!visited[nx][ny] && land[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        queue.add(new Node(nx, ny));
                        cnt++;
                    } 
                }
            }
        }
        
        for (int j : sichu) {
            count[j] += cnt;
            answer = Math.max(answer, count[j]);
        }
    } 
} 