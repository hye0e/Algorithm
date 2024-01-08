import java.util.*;

class Solution {
    static HashMap<String, Integer> info = new HashMap<>();
    

    public List<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {
        info.put("code", 0);
        info.put("date", 1);
        info.put("maximum", 2);
        info.put("remain", 3);
        
        List<int[]> tempList = new ArrayList<>();
        int[][] answer = new int[data.length][4];
        
        int index = info.get(ext);
        int sortIndex = info.get(sort_by);
        
        for (int i = 0; i < data.length; i++) {
            if (data[i][index] < val_ext) {
                tempList.add(data[i]);
            }
        }
        
        Collections.sort(tempList, (o1,o2) -> o1[sortIndex] - o2[sortIndex]);
        
        return tempList;
    }
}