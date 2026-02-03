class Solution {
    // 1. 모음 정의
    static final char[] VOWELS = {'A', 'E', 'I', 'O', 'U'};
    static int count = 0;    // 몇 번째 단어인지 세는 변수
    static int answer = 0;   // 정답을 저장할 변수
    
    public int solution(String word) {
        // 테스트 케이스마다 전역 변수 초기화 필수
        count = 0;
        answer = 0;
        
        dfs("", word);
        
        return answer;
    }
    
    public void dfs(String current, String target) {
        // 이미 정답을 찾았으면 더 이상 탐색하지 않음 (최적화)
        if (answer > 0) return;
        
        // 현재 만든 단어가 찾으려는 단어와 같다면 정답 저장
        if (current.equals(target)) {
            answer = count;
            return;
        }
        
        // 길이가 5가 되면 더 이상 글자를 붙일 수 없으므로 리턴
        if (current.length() == 5) {
            return;
        }
        
        // 5개의 모음을 순서대로 붙임
        for (int i = 0; i < 5; i++) {
            count++; // 사전에 단어가 추가될 때마다 번호 증가
            dfs(current + VOWELS[i], target);
        }
    }
}
