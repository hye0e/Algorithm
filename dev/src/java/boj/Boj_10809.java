package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_10809 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        for (char c = 'a'; c <= 'z'; c++) {
            System.out.print(input.indexOf(c) + " ");
        }
    }
}
