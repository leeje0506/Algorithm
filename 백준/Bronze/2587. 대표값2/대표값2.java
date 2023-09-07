

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] arr = new int [5];
		int sum =0;  //합
		int avg =0;  //평균
		
		for(int tc=0; tc<5; tc++) {
			arr[tc]=sc.nextInt();			
		}
		
		Arrays.sort(arr);
		
		for(int i=0; i<5; i++) {
			sum += arr[i];			
		}
		avg = sum /5;
		
		System.out.println(avg);
		System.out.println(arr[2]);
	}
}
