package dev;

import java.util.Scanner;

public class Boj_1712 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        if (C - B > 0) {
            System.out.println(A/(C-B)+1);
        } else {
            System.out.println(-1);
        }
    }
}
