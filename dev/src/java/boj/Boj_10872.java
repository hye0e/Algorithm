package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = Integer.parseInt(br.readLine());
        System.out.print(factorial(answer));
    }
    static int factorial(int num) {
       if (num == 1)  return num;
       else if (num == 0) return 1;
       else return num * factorial(num - 1);
    }
}
