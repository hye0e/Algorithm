import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        List<String> cache = new ArrayList<>();
        
        if (cacheSize == 0) return 5 * cities.length;
        
        for (String city : cities) {
            city = city.toUpperCase(); // 대소문자 구분 안하니까
            
            // 캐시에 포함되지 않았다면
            if (!cache.contains(city)) {
                // 꽉 차있다면 먼저것 지우기
                if (cache.size() == cacheSize) {
                    cache.remove(0);
                }
                // 캐시에 추가 ) cache miss 5
                cache.add(city);
                answer += 5;
            } else {
                // 캐시가 존재한다면
                // 지우고 다시 추가 ) LRU이기 때문
                cache.remove(city);
                cache.add(city);
                answer++; 
            }
        }
        
        return answer;
    }
}