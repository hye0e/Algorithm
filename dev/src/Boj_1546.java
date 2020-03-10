import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 세준이는 기말고사를 망쳤다. 세준이는 점수를 조작해서 집에 가져가기로 했다.
 * 1. 일단 세준이는 자기 점수 중에 최댓값을 골랐다. 이 값을 M이라고 한다.
 * 2. 그리고 나서 모든 점수를 점수/M*100으로 고쳤다.
 *
 * 예를 들어, 세준이의 최고점이 70이고, 수학점수가 50이었으면 수학점수는 50/70*100이 되어 71.43점이 된다.
 *
 * 세준이의 성적을 위의 방법대로 새로 계산했을 때, 새로운 평균을 구하는 프로그램을 작성하시오.
 */
public class Boj_1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        double[] newArr = new double[cnt];
        double max = 0;
        double sum = 0;

        for (int i = 0; i < cnt; i++) {
            newArr[i] = Double.parseDouble(input[i]);

            max = newArr[i] > max ? newArr[i] : max;
        }

        for (int i = 0; i < newArr.length; i++) {
            sum += (newArr[i]/max) * 100;
        }

        System.out.println(sum / cnt);
    }
}
