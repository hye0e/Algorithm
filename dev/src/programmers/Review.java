package programmers;

import java.util.Stack;
import org.junit.Assert;
import org.junit.Test;

public class Review {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> backet = new Stack<>();
        backet.push(0);

        for (int move: moves) {
            for (int i = 0; i < board.length; i++) {
                System.out.println(board[i][move - 1]);
            }
        }
        return answer;
    }

    @Test
    public void 정답(){
        Assert.assertEquals(4, solution(new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int[]{1,5,3,5,1,2,1,4}));
//        Assert.assertEquals(8, solution(new int[][]{{3,3,3,3,3},{3,3,3,3,3},{3,3,3,3,3},{3,3,3,3,3},{3,3,3,3,3}}, new int[]{1,5,3,5,1,2,1,4}));
//        Assert.assertEquals(0, solution(new int[][]{{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}}, new int[]{1,5,3,5,1,2,1,4}));
    }
}
