import java.util.*;

class Solution {
    static int N; 
    static int cnt;
    static int[] num; // index 배열
    static int[] cases;
    static boolean[] visited;
    static int K; // 총 피로도
    static int[][] DUNGEONS;
    static int answer;
    public int solution(int k, int[][] dungeons) {
        // 1. index배열 생성 -> 만들 수 있는 조합 모두 만들기
        N = dungeons.length;
        K = k;
        DUNGEONS = dungeons;
        num = new int[N];
        cases = new int[N];
        visited = new boolean[N];
        
        for (int i = 0; i < N; i++) {
            num[i] = i;
        }

        dfs(0);
        
        return answer;
    }
    
    public static void dfs(int start) {
        if (start == N) {
            answer = Math.max(answer, goDungeons(cases));
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                cases[start] = num[i];
                dfs(start + 1);
                visited[i] = false;
            }
        }
    }
    
    public static int goDungeons(int[] indexArr) {
        int cnt = 0;
        int totalPiro = K;
        for (int i = 0; i < N; i++) {
            int dungeonsIndex = indexArr[i];
            int minPiro = DUNGEONS[dungeonsIndex][0];
            int usePiro = DUNGEONS[dungeonsIndex][1];
            if (minPiro <= totalPiro) {
                totalPiro -= usePiro;
                cnt++;
            }
        }
        
        return cnt;
    }
}