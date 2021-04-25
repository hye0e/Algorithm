package programmers;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;

public class prgmers_0317 {
    public static void main(String[] args) {
        String[] phone_book = {"97674223", "119", "1195524421"};
        System.out.println(solution(phone_book));
    }
    static boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            if(phone_book[i + 1].startsWith(phone_book[i])) return false;
        }

        return answer;
    }
}
