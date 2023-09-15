

import java.util.Scanner;
import java.util.Stack;

public class Main {
	static Stack<Integer> stack = new Stack<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		
		for(int i=0; i<K; i++) {
			int a = sc.nextInt();
			if(a>0) {
				stack.push(a);
			}else {
				stack.pop();
			}
		}
		int answer =0;
		while(!(stack.isEmpty())) {			
			answer += stack.pop();
		}
		
		System.out.println(answer);
	}
}
