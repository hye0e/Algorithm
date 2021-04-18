package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] people = new int[9];
        int sum = 0;
        for (int i = 0; i < people.length; i++) {
            people[i] = sc.nextInt();
            sum += people[i];
        }
        Arrays.sort(people);
        for (int i = 0; i < people.length - 1; i++) {
            for (int j = i + 1; j < people.length; j++) {
                if ((sum - (people[i] + people[j]) == 100)) {
                    for (int k = 0; k < people.length; k++) {
                        if (i == k || j == k) continue;
                        System.out.println(people[k]);
                    }
                    System.exit(0);
                }
            }
        }
    }
}
