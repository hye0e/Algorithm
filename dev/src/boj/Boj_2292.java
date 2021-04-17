package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2292 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int min = 2;
        int rmCnt = 1;
        if (input == 1) System.out.println(1);
        else {
            while(min <= input) {
                min += 6 * rmCnt;
                rmCnt++;
            }
            System.out.println(rmCnt);
        }
    }
}
