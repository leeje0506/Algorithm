class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[num_list.length];
        int index = 0;
        for (int i = n; i < num_list.length; i++) {
            answer[index++] = num_list[i];
        }
        //index는 앞서 증가한 값이 유지되고 있으므로, answer 배열에 연이어 원소가 채워짐
        for (int i = 0; i < n; i++) {
            answer[index++] = num_list[i];
        } 
        return answer;
    }
}   