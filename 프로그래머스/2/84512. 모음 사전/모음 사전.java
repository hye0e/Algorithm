import java.util.*;

class Solution {
    static List<String> wordResult = new ArrayList<>();
    static int N;
    static String[] dictation = new String[]{"A", "E", "I", "O", "U"};
    static int answer = 0;
    static String WORD;
    public void permutation(String s, int depth, int answer) {
        wordResult.add(s);
        if (depth == 5) {
            return;
        } 
               
        for (int i = 0; i < 5; i++) {
            permutation(s + dictation[i], depth + 1, answer + 1);
        }
    }
    public int solution(String word) {
        N = word.length();
        WORD = word;
        permutation("", 0, 0);

        return wordResult.indexOf(word);
    }
}