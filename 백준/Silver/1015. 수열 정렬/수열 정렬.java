import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Num[] arr;

    static class Num implements Comparable<Num> {
        int index, origin;

        public Num(int index, int origin) {
            this.index = index;
            this.origin = origin;
        }

        public int getIndex() {
            return index;
        }

        @Override
        public String toString() {
            return "Num{" +
                    "index=" + index +
                    ", origin=" + origin +
                    '}';
        }

        public int getOrigin() {
            return origin;
        }

        @Override
        public int compareTo(Num o) {
            if (this.origin == o.origin) return this.index - o.index;
//            return this.index - o.index;
            return this.origin - o.origin;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(arr);
        print();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Num[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = new Num(i, Integer.parseInt(st.nextToken()));
        }
    }

    public static void print() {
        int[] P = new int[N];
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (Num num : arr) {
            P[num.getIndex()] = index;
            index++;
        }

        for (int num : P) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}
