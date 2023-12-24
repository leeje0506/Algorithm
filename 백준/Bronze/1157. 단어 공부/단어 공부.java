import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int [] alpa = new int [26];
		String str = br.readLine();
		
		for (int i = 0; i < str.length(); i++){
			 
			if (65 <= str.charAt(i) && str.charAt(i) <= 90) { // 대문자 범위
				alpa[str.charAt(i) - 65]++;	// 해당 인덱스의 값 1 증가
			}
		    
			else {	// 소문자 범위
				alpa[str.charAt(i) - 97]++;
			}
		 
		}
		
		int max = -1;
		char ch = '?';
		for (int i = 0; i < 26; i++) {
 
			if (alpa[i] > max) {
				max = alpa[i];
				ch = (char) (i + 65);
			} 
			else if (alpa[i] == max) {
				ch = '?';
			}
		}
		
		System.out.println(ch);
	}

}
