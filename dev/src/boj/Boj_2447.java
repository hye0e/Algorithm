package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2447 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        print(input);
    }

    static void print(int input) {
        StringBuilder sb = new StringBuilder();
        int temp = input;
        int length = input / 3;
        for (int i = 0; i < length; i++) {
            sb.append("***\n" +
                      "* *\n" +
                      "***");
            for (int j = 0; j < 9; j++) {
                System.out.println();
            }

        }
        System.out.println(sb);
    }
}
