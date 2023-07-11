class Solution {
    static int[] STONES;
    static int K;
    
    public int solution(int[] stones, int k) {
        int answer = 0;
        STONES = stones;
        K = k;
        
        int min = 1;
        int max = Integer.MAX_VALUE;
        
        while (min <= max) {
            int mid = (min + max) / 2;
            
            if (go(mid)) {
                min = mid + 1;
                answer = Math.max(answer, mid);
            } else {
                max = mid - 1;
            }
        }
        return answer;
    }
    
    public boolean go(int friends) {
        int skip = 0;
        for (int stone: STONES) {
            // 갈 수 없음
            if (stone - friends < 0) {
                skip++;
            } else {
                skip = 0;
            }
            
            if (skip == K) return false;
        }
        return true;
    }
}