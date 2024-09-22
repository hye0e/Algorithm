import java.util.*;

class Solution {
    static HashSet<String> visited = new HashSet<>();
    static HashMap<Character, int[]> map = new HashMap<>();

    public int solution(String dirs) {
        map.put('R', new int[]{1, 0});
        map.put('L', new int[]{-1, 0});
        map.put('U', new int[]{0, 1});
        map.put('D', new int[]{0, -1});

        int startX = 0;
        int startY = 0;
        int answer = 0;

        for (int i = 0; i < dirs.length(); i++) {
            char dir = dirs.charAt(i);
            int[] move = map.get(dir);

            int nx = startX + move[0];
            int ny = startY + move[1];

            // 경계를 벗어나는지 확인
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) {
                continue;
            }

            // 이동 경로를 문자열로 표현
            String path1 = startX + "," + startY + "->" + nx + "," + ny;
            String path2 = nx + "," + ny + "->" + startX + "," + startY;

            // 처음 지나가는 길인지 확인
            if (!visited.contains(path1) && !visited.contains(path2)) {
                visited.add(path1);
                visited.add(path2);
                answer++;
            }

            startX = nx;
            startY = ny;
        }

        return answer;
    }
}
