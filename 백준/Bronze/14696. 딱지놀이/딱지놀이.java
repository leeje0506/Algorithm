import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
//		sc.nextLine(); //버퍼 날리기

		for(int t=1; t<=N; t++) {
			int [] Acnt = new int [5];
			int [] Bcnt = new int [5];
			int A = sc.nextInt();
			int [] Aarr = new int[A];
			for(int a=0; a<A; a++) {
				Aarr[a] = sc.nextInt();
				Acnt[Aarr[a]]++;
			}
			int B = sc.nextInt();
			int [] Barr = new int[B];
			for(int b=0; b<B; b++) {
				Barr[b] = sc.nextInt();
				Bcnt[Barr[b]]++;
			}
			
			
//			int max =0; 
//			int Awin = 0;
//			int Bwin = 0;
//			int Dwin = 0;
			
			outer : for(int i=4; i>=0; i--) {	
				if(Acnt[i] != Bcnt[i]) {
					if(Acnt[i]>Bcnt[i]) {
						System.out.println("A");
						break;
					}
					if(Bcnt[i]>Acnt[i]) {
						System.out.println("B");
						break;
					}
				}
				else {
					for(int j=i-1; j>=0; j--) {
						if(Acnt[j]>Bcnt[j]) {
							System.out.println("A");
							break outer;
						}
						if(Bcnt[j]>Acnt[j]) {
							System.out.println("B");
							break outer;
						}										
					}
					System.out.println("D");
					break;
				}
			}
			
			
		}
		
	}
}
