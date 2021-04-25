package boj;

import java.util.Scanner;

public class Boj_2798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cardCnt = sc.nextInt();
        int M = sc.nextInt();
        int[] cardArr = new int[cardCnt];
        for (int i = 0; i < cardCnt; i++) {
            cardArr[i] = sc.nextInt();
        }
        sort(cardArr, M);
    }

    public static void sort(int[] input, int M) {
        int sum = 0;
        int temp = 0;

        for(int i=0;i<input.length;i++) {
            for(int j=i+1;j<input.length;j++) {
                for(int k=j+1;k<input.length;k++) {
                    sum =input[i]+input[j]+input[k];
                    if(temp < sum && sum <= M) {
                        temp=sum;
                    }
                }
            }
        }

        System.out.println(temp);
    }
}
