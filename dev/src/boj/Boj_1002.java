package boj;

import java.util.Scanner;

public class Boj_1002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int testCnt = sc.nextInt();
        Circle ca, cb;
        // x1, y1, r1, x2, y2, r2
        for (int i = 0; i < testCnt; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int r = sc.nextInt();
            ca = new Circle(x, y, r);

            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();
            cb = new Circle(x1, y1, r1);

            sb.append(getResult(ca, cb) + "\n");
        }
        System.out.println(sb);
    }

    private static int getResult(Circle ca, Circle cb) {
        int result = 0, sumR = ca.r + cb.r, diffR = Math.abs(ca.r - cb.r);
        double dist = getDist(ca, cb);
        if (ca.x == cb.x && ca.y == cb.y) { // 중점이 같을 때
            if (ca.r == cb.r) result = -1; // 중점이 같으면서 반지름도 같을 때
            else result = 0; // 중점이 같으나, 반지름이 같지 않을 때 => 교차 지점이 없음
        } else {
            if (dist < sumR && diffR < dist) result = 2;
            else if (sumR == dist || diffR == dist) result = 1;
        }
        return result;
    }

    private static double getDist(Circle ca, Circle cb) {
        return Math.sqrt(Math.pow(cb.x - ca.x, 2) + Math.pow(cb.y - ca.y, 2));
    }

    static class Circle {
        int x, y, r;
        public Circle(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }
}
