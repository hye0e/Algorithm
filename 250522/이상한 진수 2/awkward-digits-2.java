import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();
        int answer = 0;
        for (int i = 1; i < number.length(); i++) {
            String temp = "";
            for (int j = 0; j < number.length(); j++) {
                if (i == j) {
                    temp += number.charAt(j) == '0' ? "1" : "0"; 
                } else {
                    temp += number.charAt(j);
                }
            }

            int originNum = Integer.parseInt(temp, 2);
            answer = Math.max(originNum, answer);
        }
        System.out.println(answer);
    }
}