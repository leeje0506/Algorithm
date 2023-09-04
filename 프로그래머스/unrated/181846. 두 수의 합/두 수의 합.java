// class Solution {
//     public String solution(String a, String b) {
//         String answer = "";
        
//         int A = Integer.parseInt(a);
//         int B = Integer.parseInt(b);
//         int sum = A+B;
        
//         answer = String.valueOf(sum);
//         return answer;
//     }
// }


//무조건 BigInteger 써야하는 문제였다.. int,long 다 안됨
import java.math.BigInteger;

class Solution {
    public String solution(String a, String b) {
        BigInteger numA = new BigInteger(a);
        BigInteger numB = new BigInteger(b);
        BigInteger sum = numA.add(numB);
        
        String answer = sum.toString();
        
        return answer;
    }
}