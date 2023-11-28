class Solution {
    public int[] solution(int[] numbers, String direction) {
        
        // 배열의 크기 numbers의 크기와 같게 초기화
        int[] answer = new int[numbers.length]; 

        if(direction.equals("right")){
            // 오른쪽으로 회전하는 경우
            for(int i=0; i<numbers.length; i++){
                // 오른쪽으로 회전하면 이전 인덱스의 값을 현재 위치에 저장
                answer[(i+1)%numbers.length] = numbers[i]; 
            }
        }
        else{
            // 왼쪽으로 회전하는 경우
            for(int i=0; i<numbers.length; i++){
                // 왼쪽으로 회전하면 다음 인덱스의 값을 현재 위치에 저장
                answer[i] = numbers[(i+1)%numbers.length]; 
            }
        }
        return answer;
    }
}
