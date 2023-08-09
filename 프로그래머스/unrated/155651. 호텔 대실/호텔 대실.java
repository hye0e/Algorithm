import java.util.*;

class Solution {

    public int solution(String[][] book_time) {
        int answer = 1;
        int[][] table = new int[book_time.length][2];
        
        // 템플릿화
        for (int i = 0; i < book_time.length; i++) {
            String[] startTemp = book_time[i][0].split(":");
            table[i][0] = cal(Integer.parseInt(startTemp[0]), Integer.parseInt(startTemp[1]));
            
            String[] endTemp = book_time[i][1].split(":");
            table[i][1] = cal(Integer.parseInt(endTemp[0]), Integer.parseInt(endTemp[1]));
        }
        
        Arrays.sort(table, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<Integer> checkoutTime = new PriorityQueue<>();
        checkoutTime.add(table[0][1] + 10);
        for (int i = 1; i < table.length; i++) {
            int checkout = checkoutTime.peek();
            if (table[i][0] >= checkout) {
                checkoutTime.poll();
                checkoutTime.add(table[i][1] + 10);
            } else {
                checkoutTime.add(table[i][1] + 10);
            }
        }
        System.out.println(Arrays.deepToString(table));
        return checkoutTime.size();
    }
    
    public int cal(int hour, int min) {
        return hour * 60 + min;
    }
}