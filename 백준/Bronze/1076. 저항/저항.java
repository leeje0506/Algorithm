

import java.util.Scanner;

public class Main {
	
	public static String [] color = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
	//num은 color 인덱스값
	//곱하기는 10의 인덱스값 제곱.
	
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		String m = sc.next();
		int num1=0, num2=0, mul=0;
		
		for(int i=0; i<color.length; i++) {
			if(color[i].equals(s1)) {
				num1 = 10*i;
			}
			if(color[i].equals(s2)) {
				num2 =i;
			}
			if(color[i].equals(m)) {
				mul =i;
			}

		}
		System.out.println((num1+num2)*(long)Math.pow(10,mul));
		
	}
}
