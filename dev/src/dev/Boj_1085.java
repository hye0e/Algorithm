package dev;

import java.util.Scanner;

public class Boj_1085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();
        int[] length = new int[4];
        length[0] = w - x;
        length[1] = h - y;
        length[2] = x;
        length[3] = y;
        int min = length[0];
        for (int i = 0; i < length.length; i++) {
            min = min < length[i] ? min : length[i];
        }
        System.out.println(min);
    }
}
