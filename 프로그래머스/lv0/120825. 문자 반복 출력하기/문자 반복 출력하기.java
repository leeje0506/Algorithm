// class Solution {
//     public String solution(String my_string, int n) {
//         String answer = "";
//         String[] arr = my_string.split("");
//         for(int i=0; i<my_string.length(); i++){
//             answer += arr[i].repeat(n);
//         }
//         return answer;
//     }
// }

class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        for(int i=0; i<my_string.length(); i++){
            for(int j=0; j<n; j++){
                answer += my_string.charAt(i);
            }            
        }
        return answer;
    }
}