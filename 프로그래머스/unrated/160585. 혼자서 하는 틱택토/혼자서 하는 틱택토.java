import java.util.*;

class Solution {
    static char[][] graph = new char[3][3];
    
    public int solution(String[] board) {
        int answer = -1;
        int oCnt = 0;
        int xCnt = 0;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                graph[i][j] = board[i].charAt(j);
                if (graph[i][j] == 'O') oCnt++;
                else if (graph[i][j] == 'X') xCnt++;
            }
        }
        
        if (xCnt > oCnt || oCnt - xCnt > 1) return 0;
        
        boolean oIsWin = winCheckByTaget('O');
        boolean xIsWin = winCheckByTaget('X');
        
        if (oIsWin && oCnt - xCnt != 1) return 0;
        if (xIsWin && oCnt != xCnt) return 0;
        return 1;
    }
    
    // target이 이겼는지의 유무
    private boolean winCheckByTaget(char target) {
        // 가로
        for (int i = 0; i < 3; i++) {
            if (graph[i][0] == target && graph[i][1] == target && graph[i][2] == target) return true;
        }
        
        // 세로
        for (int i = 0; i < 3; i++) {
            if (graph[0][i] == target && graph[1][i] == target && graph[2][i] == target)
                return true;
        }
        
        // 대각선
        if (graph[0][0] == target && graph[1][1] == target && graph[2][2] == target)
                return true;
        if (graph[0][2] == target && graph[1][1] == target && graph[2][0] == target)
                return true;
        
        return false;
    }
}