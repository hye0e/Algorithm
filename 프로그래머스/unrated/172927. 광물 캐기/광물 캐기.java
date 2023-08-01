class Solution {
        static int[] PICKS;
    static String[] MINERALS;

    static int answer = Integer.MAX_VALUE;
    static int total = 0;
    static int[] visited;
    public static int solution(int[] picks, String[] minerals) {
        visited = new int[picks.length];
        PICKS = picks;
        MINERALS = minerals;

        // 곡괭이의 총 개수
        for (int pick: picks) {
            total += pick;
        }

        for (int i = 0; i < picks.length; i++) {
            // 다 사용했다는 뜻
            if (picks[i] == visited[i]) continue;
            visited[i]++;
            dfs(1, 0, i, 0);
            visited[i]--;
        }
        return answer;
    }

    private static void dfs(int count, int startMineralsIdx, int pickIdx, int sum) {
        if (answer <= sum || startMineralsIdx >= MINERALS.length) return;

        int add = 0;

        // 광물 5개를 캔 후에는 더 이상 사용할 수 없습니다.
        for (int i = startMineralsIdx; i <startMineralsIdx + 5; i++) {
            if (i >= MINERALS.length) break;
            String mineral = MINERALS[i];

            add += calPirodo(pickIdx, mineral);
        }

        if (count >= total || startMineralsIdx + 5 >= MINERALS.length) {
            answer = Math.min(answer, sum + add);
            return;
        }

        for (int i = 0; i < PICKS.length; i++) {
            // 없는 곡괭이거나 이미 사용을 다 했으면
            if (PICKS[i] == 0 || PICKS[i] == visited[i]) continue;

            visited[i]++;
            dfs(count + 1, startMineralsIdx + 5, i, sum + add);
            visited[i]--;
        }
    }

    public static int calPirodo(int pickType, String minerals) {
        // dia
        if (pickType == 0) {
            return 1;
        } else if (pickType == 1) {
            if (minerals.equals("diamond")) {
                return 5;
            } else if (minerals.equals("iron")) {
                return 1;
            } else if (minerals.equals("stone")) {
                return 1;
            }
        } else if (pickType == 2) {
            if (minerals.equals("diamond")) {
                return 25;
            } else if (minerals.equals("iron")) {
                return 5;
            } else if (minerals.equals("stone")) {
                return 1;
            }
        }
        return 0;
    }
}