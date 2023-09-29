import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] canSpeak = {"aya", "ye", "woo", "ma"};
        boolean[] isVisited = new boolean[4];
        for (int i = 0; i < babbling.length; i++) {
            for (String speak: canSpeak) {
                if (babbling[i].equals(speak)) {
                    babbling[i] = "";
                    answer++;
                }
                
                if (babbling[i].startsWith(speak)) {
                    babbling[i] = babbling[i].substring(speak.length(), babbling[i].length());
                    // System.out.println(babbling[i].substring(speak.length(), babbling[i].length()));
                }
                
                if (babbling[i].endsWith(speak)) {
                    babbling[i] = babbling[i].substring(0, babbling[i].length() - speak.length());
                    System.out.println(babbling[i]);
                    // babbling[i] = babbling[i].substring(speak.length(), babbling[i].length());
                    // System.out.println(babbling[i].substring(speak.length(), babbling[i].length()));
                }
            }
        }
        
        for (int i = 0; i < babbling.length; i++) {
            for (String speak: canSpeak) {
                if (babbling[i].equals(speak)) {
                    babbling[i] = "";
                    answer++;
                }
            }
        }
        return answer;
    }
}