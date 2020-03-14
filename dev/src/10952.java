//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        StringTokenizer st;
//
//        while(true) {
//            String input = br.readLine();
//
//            if (!input.equals("0 0")) {
//                st = new StringTokenizer(input, " ");
//                int result = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
//                sb.append(result + "\n");
//
//                continue;
//            } else {
//                break;
//            }
//        }
//        System.out.println(sb);
//    }
//}
