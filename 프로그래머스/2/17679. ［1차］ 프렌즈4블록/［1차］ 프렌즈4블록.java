import java.util.*;

class Solution {
    static int[] dx = {0, 0, 1, 1};  // 2x2 블록을 확인할 방향 배열
    static int[] dy = {0, 1, 0, 1};
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] grid = new char[m][n];
        
        // String[] -> char[][] 변환
        for (int i = 0; i < m; i++) {
            grid[i] = board[i].toCharArray();
        }
        
        while (true) {
            boolean[][] visited = new boolean[m][n];
            int count = checkBlocks(m, n, grid, visited);
            
            if (count == 0) break; // 더 이상 삭제할 블록이 없으면 종료
            
            answer += count;
            removeBlocks(m, n, grid, visited);
            dropBlocks(m, n, grid);
        }
        
        return answer;
    }
    
    // 2x2 블록 찾기
    private int checkBlocks(int m, int n, char[][] grid, boolean[][] visited) {
        int count = 0;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (grid[i][j] == '.') continue;
                if (isSquare(i, j, grid)) {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (!visited[nx][ny]) {
                            visited[nx][ny] = true;
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
    
    // 2x2 블록인지 확인
    private boolean isSquare(int x, int y, char[][] grid) {
        char block = grid[x][y];
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (grid[nx][ny] != block) return false;
        }
        return true;
    }
    
    // 블록 제거
    private void removeBlocks(int m, int n, char[][] grid, boolean[][] visited) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    grid[i][j] = '.'; // 빈칸으로 만듦
                }
            }
        }
    }
    
    // 블록 내리기
    private void dropBlocks(int m, int n, char[][] grid) {
        for (int j = 0; j < n; j++) { // 각 열에 대해 실행
            List<Character> temp = new ArrayList<>();
            for (int i = m - 1; i >= 0; i--) { // 아래에서 위로 탐색
                if (grid[i][j] != '.') {
                    temp.add(grid[i][j]);
                }
            }
            while (temp.size() < m) temp.add('.'); // 빈칸 채우기
            for (int i = m - 1, k = 0; i >= 0; i--, k++) {
                grid[i][j] = temp.get(k);
            }
        }
    }
}
