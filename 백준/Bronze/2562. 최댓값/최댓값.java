import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int [] arr = new int [9];
		int max =0;
		
		for(int tc=0; tc<9; tc++) {
			arr[tc]	= sc.nextInt();
			
		}
		
		int cnt =0;
		for(int i=0; i<9; i++) {
			max = Math.max(max, arr[i]);	

		}
		
		for(int j=0; j<9; j++) {
			if(max == arr[j]) {
				cnt=j+1;
			}
		}
		System.out.println(max);
		System.out.println(cnt);
		
	}//main
}//class
	