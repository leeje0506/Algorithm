import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);		
		int [] nanjangee = new int [9];
		
		int sum=0;
		for(int i=0; i<9; i++) {
			nanjangee[i] = sc.nextInt();
			sum += nanjangee[i];
		}
		
		
		sum = sum - 100;
		outer : for(int i=0; i<9; i++) {
			for(int j=i+1; j<9; j++) {
				if(sum!=nanjangee[i] + nanjangee[j]) {
				}
				if(sum == nanjangee[i] + nanjangee[j]	) {
					nanjangee[i] =0;
					nanjangee[j] =0;
					break outer;
				}else {
					continue;
				}
			}
		}
		Arrays.sort(nanjangee);
		
		for(int i=2; i<9; i++) {
			System.out.println(nanjangee[i]);
		}

	}//main
}//class
