package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int[] rmArr = new int[100];
        int[] rmArr2 = new int[100];
        int floor;
        for (int i = 0; i < testCase; i++) {
            floor = Integer.parseInt(br.readLine());
            int roomNum = Integer.parseInt(br.readLine());
            for (int j = 0; j < roomNum; j++) {
                rmArr[j] = j + 1;
            }
        }

        for (int i = 1; i <= rmArr.length; i++) {
            if(rmArr[i] == 0) break;
            int temp = rmArr[i];
            rmArr2[i] = rmArr[i] + temp;
        }
    }
}
