//import java.io.*;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int input = Integer.parseInt(br.readLine());
//        int origin = input;
//        int count = 0;
//
//        while (true) {
//            int newNum = ((input % 10) * 10 ) + ((input / 10) + (input % 10)) % 10;
//            input = newNum;
//            count++;
//            if (origin == newNum) {
//                break;
//            }
//        }
//        System.out.println(count);
//    }
//}
//
