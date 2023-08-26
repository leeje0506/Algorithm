

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	public static Stack <Integer> line = new Stack<>();
    public static Stack <Integer> stack = new Stack<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int T = sc.nextInt();
        int std = sc.nextInt();
        std++;
        line.push(std);

        for(int tc=1; tc<T; tc++) {
            std++;
            int num = sc.nextInt();

            for(int n=1; n<=num; n++) {
                stack.push(line.pop());
            }
            line.push(std);

            for(int n=1; n<=num; n++) {
                line.push(stack.pop());
            }

        }
        //역순으로
        while (!line.isEmpty()) {
            stack.push(line.pop());
        }
        
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }//main
}//class
