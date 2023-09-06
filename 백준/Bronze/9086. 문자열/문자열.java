

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			String [] str = sc.next().split("");
			
			String answer = str[0] + str[str.length-1];
			
			System.out.println(answer);
		}
	}
}
