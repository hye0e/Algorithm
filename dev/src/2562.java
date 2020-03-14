//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int numArr[] = new int[9];
//        int max = 0;
//        int cnt = 0;
//        // 1. 배열 넣기
//        for (int i = 0; i < 9; i++) {
//            int input = Integer.parseInt(br.readLine());
//
//            numArr[i] = input;
//        }
//        // 2. 최댓값 구하기
//        for (int i = 0; i < numArr.length; i++) {
//            max = numArr[i] > max ? numArr[i] : max;
//
//            if (max == numArr[i]) {
//                cnt = i + 1;
//            }
//        }
//        System.out.println(max);
//        System.out.println(cnt);
//    }
//}
