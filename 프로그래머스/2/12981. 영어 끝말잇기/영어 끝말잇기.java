import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> used = new HashSet<>();
        used.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String cur = words[i];

            // 규칙 위반: 이미 나온 단어 or 끝말잇기 실패
            if (used.contains(cur) || prev.charAt(prev.length() - 1) != cur.charAt(0)) {
                int person = (i % n) + 1;   // 실패한 사람 번호
                int round  = (i / n) + 1;   // 실패한 차례
                return new int[]{person, round};
            }
            used.add(cur);
        }

        return new int[]{0, 0};
    }
}
