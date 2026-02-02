class Solution {
    // 1. 상태를 공유할 멤버 변수 선언
    static boolean[] visited; 
    static int maxCount = 0; 

    public int solution(int k, int[][] dungeons) {
        // 초기화 (프로그래머스는 솔루션 객체를 매번 새로 생성하거나 재사용할 수 있으므로 초기화 중요)
        maxCount = 0; 
        visited = new boolean[dungeons.length]; 

        // 2. DFS 탐색 시작 (현재 피로도 k, 방문 횟수 0)
        dfs(k, 0, dungeons);

        return maxCount;
    }

    // DFS 재귀 함수
    public void dfs(int currentK, int cnt, int[][] dungeons) {
        // 탐색할 때마다 현재 방문 횟수가 최댓값인지 확인하여 갱신
        maxCount = Math.max(maxCount, cnt);

        // 모든 던전을 순회
        for (int i = 0; i < dungeons.length; i++) {
            int minReq = dungeons[i][0]; // 최소 필요 피로도
            int use = dungeons[i][1];    // 소모 피로도

            // 1. 아직 방문하지 않았고, 2. 현재 피로도로 갈 수 있다면
            if (!visited[i] && currentK >= minReq) {
                
                visited[i] = true; // 방문 체크 (상태 변경)
                
                // 재귀 호출: 피로도는 깎이고, 방문 횟수는 1 증가
                dfs(currentK - use, cnt + 1, dungeons);
                
                visited[i] = false; // 방문 체크 해제 (백트래킹)
                // 여기서 false로 돌려놔야, 다음 루프나 다른 재귀 분기에서 
                // 이 던전을 다른 순서로 방문할 수 있음.
            }
        }
    }
}
