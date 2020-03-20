import javafx.beans.binding.StringBinding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        String[] arr = input.split("");
        int[] cntArr = new int[input.length()];
        // 초기
        for (int i = 0; i < cntArr.length; i++) {
            cntArr[i] = 0;
        }
        int max = 0;
        for (char j = 'a'; j < 'z'; j++) {
            int cnt = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].equalsIgnoreCase(String.valueOf(j))) {
                    cnt++;
                    cntArr[i] = cnt;
                }
            }
        }

        for (int i = 0; i < cntArr.length; i++) {
            max = max < cntArr[i] ? cntArr[i] : max;
        }

    }
}
