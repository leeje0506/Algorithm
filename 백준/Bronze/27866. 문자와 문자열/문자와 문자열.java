
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String [] str = sc.next().split("");
		int n = sc.nextInt();
		
		String answer = str[n-1];
		
		System.out.println(answer);
	}
}
