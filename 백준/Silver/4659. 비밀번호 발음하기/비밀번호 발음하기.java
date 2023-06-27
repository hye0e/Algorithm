import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String word = br.readLine();
            String tempWord = "<" + word + "> is ";
            if (check(word)) {
                tempWord += "acceptable.";
            } else {
                tempWord += "not acceptable.";
            }

            if (word.equals("end")) break;
            System.out.println(tempWord);
        }
    }

    public static boolean check(String word) {
        char[] wordArr = word.toCharArray();
        List<Character> characterList = new ArrayList<>();
        characterList.add('a');
        characterList.add('e');
        characterList.add('i');
        characterList.add('o');
        characterList.add('u');
        // 모음 카운트
        int cnt = 0;
        // 자음 카운트
        int elseCnt = 0;

        boolean aeiouFlag = false;
        boolean beforeFlag = false;
        int continuity = 0;

        String last = String.valueOf(wordArr[0]);
        for (int i = 0; i < wordArr.length; i++) {
            // case 1
            if (characterList.contains(wordArr[i])) {
                cnt++;
                elseCnt = 0;
                aeiouFlag = true;
            } else {
                elseCnt++;
                cnt = 0;
            }

            // 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
            if (cnt == 3 || elseCnt == 3) return false;

            // case 3
            if (i >= 1) {
                String temp = last + wordArr[i] + "";
                //  ee 와 oo는 허용한다.
                if (temp.equals("ee") || temp.equals("oo")) continue;
                // 같은 글자가 연속적으로 두번 오면 안되나
                if (last.equals(String.valueOf(wordArr[i]))) return false;
            }
            last = String.valueOf(wordArr[i]);
        }
        // 모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
        if (!aeiouFlag) return false;



        return true;
    }
}
