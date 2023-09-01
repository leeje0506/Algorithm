class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        //replaceAll(바꾸고싶은 거, 바꿀 거)
        
        String[] arr = my_string.replaceAll("[^0-9]", "").split("");
        for(int i=0; i<arr.length; i++){
            answer += Integer.parseInt(arr[i]);
        }
        return answer;
    }
}