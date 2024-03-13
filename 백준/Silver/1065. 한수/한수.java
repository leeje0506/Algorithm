import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int answer = 0; // 한수의 개수

        for (int i = 1; i <= N; i++) {
            //1~9, 10~99는 한수로 보는 듯
            if(i <= 99){
                answer += 1; 
            }else if(i <= 999){
                String [] numStr = Integer.toString(i).split("");
                //백의자리 십의자리 일의자리를 각각 a, b, c라고 생각하고 b-a == c-b 이면 한수이므로 +1
                if ((Integer.parseInt(numStr[1]) - Integer.parseInt(numStr[0])) == (Integer.parseInt(numStr[2])- Integer.parseInt(numStr[1]))) { 
                    answer += 1;
                }            
            }
        }
        System.out.println(answer);
    }
}
