class Solution {
    static int TARGET;
    static int answer = 0;
    static boolean[] visited;
    public void dfs(int[] numbers, int sum, int depth) {
        if (depth == numbers.length) {
            if (sum == TARGET) answer++;
            return;
        }
        
        dfs(numbers, sum - numbers[depth], depth + 1);
        dfs(numbers, sum + numbers[depth], depth + 1);
        
    }
    public int solution(int[] numbers, int target) {
        
        TARGET = target;
        dfs(numbers, 0, 0);
        return answer;
    }
}