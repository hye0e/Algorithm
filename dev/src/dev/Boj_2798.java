package dev;

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
        int[] card = new int[100];
        int index = 0;
        for (int i = 0; i < input.length; i++) {
            sum = input[i];
            for (int j = i + 1; j < input.length - 1; j++) {
                sum += input[j] + input[j + 1];
                if (M >= sum) {
                    card[index] = sum;
                    index++;
                }
                sum = input[i];
            }
        }

        for (int i = 0; i < index; i++) {
            System.out.println(card[i]);
        }
    }
}
