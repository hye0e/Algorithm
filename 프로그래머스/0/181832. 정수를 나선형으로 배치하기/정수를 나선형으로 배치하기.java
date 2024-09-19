import java.util.*;
class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int dir = 0;
    int n;
    public boolean isRange(int nx, int ny) {
        return 0 <= nx && nx < n && 0 <= ny && ny < n;
    }
    public int[][] solution(int n) {
        n = n;
        int[][] answer = {};
        int[][] graph = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        
        int x = 0; 
        int y = 0;
        int num = 1;
        graph[x][y] = 1;
        for (int i = 0; i < n * n; i++) {
            graph[x][y] = num++; // 현재 위치에 값 할당
            int nx = x + dx[dir]; // 다음 위치 계산
            int ny = y + dy[dir];
            
            // 다음 위치가 범위를 벗어나거나 이미 채워진 경우
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || graph[nx][ny] != 0) {
                dir = (dir + 1) % 4; // 방향 전환
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            
            x = nx;
            y = ny;
        }
        
        return graph;
    }
}