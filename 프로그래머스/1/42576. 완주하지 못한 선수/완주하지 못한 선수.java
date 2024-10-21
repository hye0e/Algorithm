import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> nameSet = new HashMap<>();
        for (String name : participant) {
            nameSet.put(name, nameSet.getOrDefault(name, 0) + 1);
        }
        
        for (String name : completion) {
            nameSet.put(name, nameSet.get(name) - 1);
        }
        
        for (String name : nameSet.keySet()) {
            if (nameSet.get(name) == 1) {
                answer = name; 
            }
        }
        
        return answer;
    }
}