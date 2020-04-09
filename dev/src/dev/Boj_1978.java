package dev;

import java.util.Scanner;

public class Boj_1978 {
    public static final int MAX = 1001;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] isPrime = new boolean[MAX];
        for(int i = 2; i < MAX; i++) {
            isPrime[i] = true;
        }

        for(int i = 2; i < MAX; i++) {
            for(int j = 2 * i; j < MAX; j += i) {
                if(!isPrime[j]) continue;
                isPrime[j] = false;
            }
        }
        int n = sc.nextInt();
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if(isPrime[x])
                ++cnt;
        }
        System.out.println(cnt);
    }
}
