package dev;

import java.io.IOException;
import java.util.Scanner;

public class Boj_10250 {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int cnt = sc.nextInt();
        for (int i = 0; i < cnt; i++) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            int N = sc.nextInt();
            int floor = N % H;
            int num;
            if (floor == 0) {
                floor = H;
                num = (N / H);
//                sb.append((N % H * 100) + (N / H) + 1);
            } else {
                num = (N / H) + 1;

//                sb.append(H + (N / H));
            }
            sb.append(floor * 100 + num);
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
