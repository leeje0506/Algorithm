import java.util.*;

class Solution {
    public int solution(int n) {
		int answer = 0;
		String str = String.valueOf(n);
		for(int i = 0; i < str.length(); i++){
			answer += Integer.parseInt(String.valueOf(str.charAt(i)));
		}
		return answer;
    }
}
    
    //다른 풀이
// import java.util.*;

// public class Solution {
//     public int solution(int n) {
//         int answer = 0;

//         while(true){
//             answer+=n%10;
            
//             if(n<10) break;
            
//             n=n/10;
//         }
//         return answer;
//     }
// }