package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_10870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        System.out.println(fibonacci(input));
    }
    static int fibonacci(int num) {
        if (num == 0) return 0;
        else if (num == 1) return 1;
        else return fibonacci(num - 1) + fibonacci(num - 2);
    }
}
