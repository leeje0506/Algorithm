import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String answer = "";
        
        //a~z 97 ~122
        //A~Z 65~90
    
       for(int i=0; i<a.length(); i++) {
           char c = a.charAt(i);
           
           if(Character.isUpperCase(c)){
               answer += Character.toLowerCase(c);
           }else{
               answer += Character.toUpperCase(c);
           }
       }
       System.out.println(answer);
    }
}