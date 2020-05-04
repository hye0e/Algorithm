package dev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =  new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        int result = splitNum(num);
        sb.append(result);
        System.out.println(sb);
    }
    public static int splitNum(int num) {
        int min = 0;
        for (int i = 0; i < num; i++) {
            int newNum = i;
            int temp = newNum;
            while (newNum > 0) {
                temp += newNum % 10;
                newNum /= 10;
            }
            if (temp == num) {
                min = i;
                break;
            }
        }
        return min;
    }
}
