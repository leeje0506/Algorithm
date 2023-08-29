import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int N = sc.nextInt(); //바구니의 수
		int M = sc.nextInt(); //반복할 횟수
		
		int [] arr = new int [N];
		int cnt=1;// 바구니
		for(int i=0; i<N; i++) {
			arr[i]=cnt++;
		}
		
		for(int t=0; t<M; t++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			
//			for(int i=0; i<N; i++) {
				for(int j=s-1; j<e; j++) {
					for(int n=j; n<e; n++) {
						int tmp = arr[n];
						arr[n] = arr[j];
						arr[j]	= tmp;
					}
				}
//			}
			
		}
		
		for(int i=0; i<N; i++) {
			System.out.print(arr[i]+" ");
		}
		
	}//main
}//class
