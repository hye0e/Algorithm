package dev;

import java.awt.print.Pageable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;

public class Boj_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sugar = Integer.parseInt(br.readLine());
        int box = 0;

        while(true) {
            if(sugar%5 == 0) {
                box += sugar/5;
                break;
            }
            sugar -= 3;
            box += 1;

            if(sugar<0) {
                box = -1;
                break;
            }
        }
        System.out.println(box);
    }
}

