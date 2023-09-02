class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        int cnt=0;
        int idx=0;
        
        for(int i=0; i<todo_list.length; i++){
             if(finished[i] != true){
                 cnt++;
             }
        }
        String[] answer = new String [cnt];
            
        for(int i=0; i<todo_list.length; i++){
            if(finished[i] != true){
                answer[idx++] = todo_list[i];
            }
        }
        return answer;
    }
}