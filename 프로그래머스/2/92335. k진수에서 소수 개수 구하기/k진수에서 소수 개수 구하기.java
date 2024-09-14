import java.util.*;

class Solution {
    public boolean isPrime (long a){
        
        if(a<2) return false;
        
        for(int i=2;i<=Math.sqrt(a);i++){
            if(a%i==0){
                return false;
            }
        }
        return true;
    }
    
    public int solution(int n, int k) {
        int answer = 0;
        // 진법 변환
        String num = Integer.toString(n, k);
        
        // 0으로 자름 	[211, 2, 1, 1, 11]
        String[] arr = num.split("0");
        System.out.println(Arrays.toString(arr));
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("")) continue;
            if (isPrime(Long.parseLong(arr[i]))) answer++;
        }
       
        
        return answer;
    }
}