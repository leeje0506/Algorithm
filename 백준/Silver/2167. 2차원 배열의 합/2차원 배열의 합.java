import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int [][] arr = new int[N][M];
		
		
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				arr[r][c] = sc.nextInt();
			}
		}
		
		int k = sc.nextInt();
		for(int i=0; i<k; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			int sum =0;
			for(int n=x1-1; n<x2; n++) {
				for(int m=y1-1; m<y2; m++) {
					sum += arr[n][m]; 			
				}
			}
			System.out.println(sum);

			
//			System.out.print(x1+" ");
//			System.out.print(y1+" ");
//			System.out.print(x2+ " ");
//			System.out.print(y2+ " ");
		}
		
		
	}//main
}//class
