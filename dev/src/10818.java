import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int numArr[] = new int[input];

        String inputArr = br.readLine();

        StringTokenizer st = new StringTokenizer(inputArr, " ");
        for(int i = 0; i < numArr.length; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }
        // 1. 최솟 최대 둘다 일단 배열의 1번째 값으로
        int min = numArr[0];
        int max = numArr[0];

        // 2. 2번째 배열부터 끝까지 1번째 애랑 비교
        for(int i = 1; i < numArr.length; i++) {
            min = min > numArr[i] ? numArr[i] : min;
            max = max < numArr[i] ? numArr[i] : max;
        }

        System.out.println(min);
        System.out.println(max);
    }
}

