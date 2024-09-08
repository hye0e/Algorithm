class Solution {
    static int[] selected;
    static boolean[] visited;
    static int n;
    static int[][] DUNGEONS;
    static int K;
    static int answer = 0;
    
    public int canGo(int[] selected) {
        int now = K;
        int count = 0;
        
        for (int i = 0; i < selected.length; i++) {
            int index = selected[i];
            if (now < DUNGEONS[index][0]) break;
            now -= DUNGEONS[index][1];
            if (now < 0) break;
            count++;
        }
        
        return count;
    }
    
    public void permutation(int depth) {
        if (depth == n) {
            answer = Math.max(answer, canGo(selected));
        }
        
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            selected[depth] = i;
            visited[i] = true;
            permutation(depth + 1);
            visited[i] = false;
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        // 최소 필요 피로도, 소모 피로도
        K = k;
        n = dungeons.length;
        selected = new int[n];
        visited = new boolean[n];
        DUNGEONS = dungeons;
        permutation(0);
        return answer;
    }
}