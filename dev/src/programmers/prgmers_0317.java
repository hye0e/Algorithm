package programmers;

import java.nio.file.Path;

public class prgmers_0317 {
    public static void main(String[] args) {
        String[] phone_book = {"123","456","789"};
        System.out.println(solution(phone_book));
    }
    static boolean solution(String[] phone_book) {
        boolean answer = true;
        for (int i = 0; i < phone_book.length - 1; i++) {
            for (int j = i+1; j < phone_book.length; j++) {
                if (phone_book[i].startsWith(phone_book[j])) { return false; }
                if (phone_book[j].startsWith(phone_book[i])) { return false; }
            }
        }

        return answer;
    }
}
