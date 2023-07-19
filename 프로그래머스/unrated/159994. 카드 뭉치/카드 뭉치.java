class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        int cards1Index = 0;
        int cards2Index = 0;
        
        for (int i = 0; i < goal.length; i++) {
            String target = goal[i];
            
            if (cards1Index < cards1.length && target.equals(cards1[cards1Index])) {
                cards1Index++;
            } else if (cards2Index < cards2.length && target.equals(cards2[cards2Index])) {
                cards2Index++;
            } else {
                return "No";
            }
        }
        
        
        return "Yes";
    }
    
}