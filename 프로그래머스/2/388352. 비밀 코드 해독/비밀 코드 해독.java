import java.util.*;

class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        List<int[]> candidates = new ArrayList<>();
        generateCombinations(n, 5, 1, new int[5], 0, candidates);
        
        int count = 0;
        for (int[] candidate : candidates) {
            boolean isValid = true;
            for (int i = 0; i < q.length; i++) {
                int match = countMatch(candidate, q[i]);
                if (match != ans[i]) {
                    isValid = false;
                    break; // 조건 불일치 시 가지치기
                }
            }
            if (isValid) count++;
        }
        return count;
    }

    // 조합 생성: n개 중 r개를 고르는 모든 조합
    private void generateCombinations(int n, int r, int start, int[] current, int depth, List<int[]> result) {
        if (depth == r) {
            result.add(current.clone());
            return;
        }
        for (int i = start; i <= n - (r - depth) + 1; i++) {
            current[depth] = i;
            generateCombinations(n, r, i + 1, current, depth + 1, result);
        }
    }

    // 두 배열 간 중복 원소 개수 세기 (정렬되어 있음)
    private int countMatch(int[] a, int[] b) {
        int i = 0, j = 0, count = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                count++;
                i++;
                j++;
            } else if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }
        return count;
    }
}