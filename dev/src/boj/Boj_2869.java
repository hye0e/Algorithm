package boj;

import java.util.Scanner;

public class Boj_2869 {
    static int A,B,V;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        V = sc.nextInt();

       int day = (V - B)/(A - B);
       if ((V - B)%(A - B) != 0) {
           day++;
       }
        System.out.println(day);
    }
}
