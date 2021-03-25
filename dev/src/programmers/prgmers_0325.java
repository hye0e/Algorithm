package programmers;

import java.util.HashMap;

public class prgmers_0325 {
    public static void main(String[] args) {
        String[][] cloother = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(cloother.length);
        pushHash(cloother);
    }
    public int solution(String[][] clothes) {
        int answer = 0;
        return answer;
    }
    static void pushHash(String[][] clothes) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            hashMap.put(clothes[i][0], clothes[i][1]);
        }
    }
}
