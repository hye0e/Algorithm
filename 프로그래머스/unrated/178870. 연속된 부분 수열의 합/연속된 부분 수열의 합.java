class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int temp = 0;
        int end = 0;
        int minLen = Integer.MAX_VALUE; // 길이가 가장 짧은 수열을 찾기위함
        int minIndex = Integer.MAX_VALUE; // 시작 인덱스가 작은 수열을 찾기위함
        
        int a_start = 0;
        int a_end = 0;
        for (int start = 0; start < sequence.length; start++) {            
            while (end < sequence.length && temp < k) {
                temp += sequence[end];
                end++;
            }
            if (temp == k) {
                int tempLen = (end - 1) - start;
                // int tempLen = (end - 1) - start;
                // 합이 k인 부분 수열이 여러 개인 경우 길이가 짧은 수열을 찾습니다.
                if (minLen == tempLen) {
                    // 길이가 짧은 수열이 여러 개인 경우 앞쪽(시작 인덱스가 작은)에 나오는 수열을 찾습니다.
                    if (minIndex > start) {
                        minIndex = start;
                    }
                } else {
                    minLen = tempLen;
                    a_start = start;
                    a_end = end - 1; // 왜 -1로 해야하는 지 잡아야함;;
                }
            }
             
            temp -= sequence[start];
        }
        answer[0] = a_start;
        answer[1] = a_end;
        return answer;
    }
}