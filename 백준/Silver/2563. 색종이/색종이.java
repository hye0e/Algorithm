import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int paperCnt = Integer.parseInt(br.readLine());
        int cnt = 0;
        // 가로, 세로의 크기가 각각 100인 정사각형 모양의 흰색 도화지가 있다
        boolean[][] arr = new boolean[100][100];
        for (int i = 0; i < paperCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    // 방문 체크
                    if (!arr[j][k]) {
                        arr[j][k] = true;
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);

    }
}
