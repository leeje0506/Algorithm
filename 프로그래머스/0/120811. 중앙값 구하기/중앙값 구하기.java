class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        // 배열 정렬 (버블 정렬)
        //길이-1 해주는 이유는 j+1이라 나중에 마지막 배열을 나가서 오류가 생김.
        for(int i = 0; i < array.length - 1; i++){
            for(int j = 0; j < array.length - 1 - i; j++){
                if(array[j] > array[j+1]){
                    // 배열 내에서 직접 값 교환
                    change(array, j, j+1);
                }
            }
        }
        
        answer = array[(array.length/2)];
        
        return answer;
    }
    
    // 배열 내에서 두 값을 교환하는 메서드
    public void change(int[] array, int index1, int index2){
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
}