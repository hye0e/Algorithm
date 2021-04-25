package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class prgmers_0325 {
    public static void main(String[] args) {
        String[][] cloother = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        System.out.println(cloother.length);
        pushHash(cloother);
    }
    public int solution(String[][] clothes) {
        int answer = 0;
        return answer;
    }
    static int pushHash(String[][] clothes) {
        HashMap<String, String> hashMap = new HashMap<>();
        List<String> category = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < clothes.length; i++) {
            hashMap.put(clothes[i][0], clothes[i][1]);
            if (!category.contains(clothes[i][1])) {
                category.add(clothes[i][1]);
            }
            cnt++;
        }

        if (category.size() != 1) {
            cnt += category.size();
        }


        return cnt;
    }
}
