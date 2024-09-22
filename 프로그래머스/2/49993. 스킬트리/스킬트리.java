import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String skill_tree : skill_trees) {
            StringBuilder filtered = new StringBuilder();
            
            // skill_tree에서 skill에 포함된 문자들만 추출
            for (char c : skill_tree.toCharArray()) {
                // 존재하면
                if (skill.indexOf(c) != -1) {
                    filtered.append(c);
                }
            }
            
            // 추출된 스킬 순서가 skill의 선행 순서와 맞는지 확인
            if (skill.startsWith(filtered.toString())) {
                answer++;
            }
        }

        return answer;
    }
}