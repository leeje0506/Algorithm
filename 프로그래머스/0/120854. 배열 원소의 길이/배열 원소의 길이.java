class Solution {
    public int[] solution(String[] strlist) {
        int[] answer = new int[strlist.length];
        int idx =0;
        
        for(int i=0; i<strlist.length; i++){
            answer[idx++] = strlist[i].length();
        }
        
        return answer;
    }
}