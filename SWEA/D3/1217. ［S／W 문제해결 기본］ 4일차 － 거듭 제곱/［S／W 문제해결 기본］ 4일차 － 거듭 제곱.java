

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int T= 10;
		
		for(int tc=1; tc<=T; tc++) {
			
			int a = sc.nextInt();
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			System.out.println("#" + tc + " " + pow(num1, num2));
			
		}
		
	}
	
	private static int pow(int n, int m) {
		//기저
		if (m == 1) {
			return n;
		}
		//실행
		else {
			return n * pow(n, m-1);
		}
		
	}
	
}
