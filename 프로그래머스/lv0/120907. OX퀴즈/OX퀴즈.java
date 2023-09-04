class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String [quiz.length];
        
        for(int i=0; i<quiz.length; i++){
            String[] str = quiz[i].split(" ");
            if(str[1].equals("+")){
                if(Integer.parseInt(str[4]) == (Integer.parseInt(str[0]) + Integer.parseInt(str[2]))){
                    answer[i] = "O";
                }else{
                    answer[i] = "X";
                }
            }
            else if(str[1].equals("-")){
                if(Integer.parseInt(str[4]) == (Integer.parseInt(str[0]) - Integer.parseInt(str[2]))){
                    answer[i] = "O";
                }else{
                    answer[i] = "X";
                }
            }
            
        }
        return answer;
    }
}