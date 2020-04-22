package dev;

import java.util.Scanner;

public class Boj_3053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        System.out.printf("%.6f\n", (double) R * R * 3.1415926535897932384626433);
        System.out.printf("%.6f\n", (double) 2 * R * R);
    }
}
