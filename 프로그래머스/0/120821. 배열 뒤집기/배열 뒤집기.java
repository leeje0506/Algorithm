class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = {};
        
        reverse(num_list);
        answer = num_list;
    
        return answer;
    }
    
    public static void reverse(int[] array){
        int start = 0;
        int end = array.length-1;
        
        while(start<end){
            int tmp = array[start];
            array[start] = array[end];
            array[end] = tmp;
            
            start++;
            end--;
        }
    }
}