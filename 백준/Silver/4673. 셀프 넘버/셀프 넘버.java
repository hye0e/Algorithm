public class Main {

    public static void main(String[] args) {
        boolean[] selfNumber = new boolean[10001];
        for (int i = 1; i <= 10000; i++) {
            int index = cal(i);

            if (index <= 10000) {
                selfNumber[index] = true;
            }

            if (!selfNumber[i]) {
                System.out.println(i);
            }
        }
    }

    public static int cal(int num) {
        int value = num;

        while (num != 0) {
            value = value + (num % 10);
            num /= 10;
        }

        return value;
    }
}
