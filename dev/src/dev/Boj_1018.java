package dev;

import java.io.IOException;
import java.util.Scanner;

public class Boj_1018 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int width = sc.nextInt();
        int height = sc.nextInt();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.println(i + "," + j);
            }
        }
    }
}
