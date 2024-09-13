class Solution {
    static int TARGET;
    static boolean[] visited;
    static int[] selected;
    static int answer = 0;
    
    public void dfs(int sum, int depth, int[] numbers) {
        if (depth == numbers.length) {
            if (sum == TARGET) {
                answer++;
            
            }
            return;
        }
       
        
        dfs(sum + numbers[depth], depth + 1, numbers); 
        dfs(sum - numbers[depth], depth + 1, numbers); 
    }
    
    public int solution(int[] numbers, int target) {
        TARGET = target;
        dfs(0, 0, numbers);
        return answer;
    }
}