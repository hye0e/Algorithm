package dev;

import java.util.Scanner;

public class Boj_4153 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if (a == 0 && b == 0 && c == 0) {
                break;
            } else {
                if (Math.pow(c, 2) +  Math.pow(b, 2) == Math.pow(a, 2) ||
                        Math.pow(a, 2) +  Math.pow(c, 2) == Math.pow(b, 2) ||
                        Math.pow(a, 2) +  Math.pow(b, 2) == Math.pow(c, 2)) {
                    sb.append("right");
                } else {
                    sb.append("wrong");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
