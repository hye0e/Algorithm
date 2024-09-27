class Solution {
    int sum = 0;
    
    public int solution(int n) {
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        
        
        return sum;
    }
}