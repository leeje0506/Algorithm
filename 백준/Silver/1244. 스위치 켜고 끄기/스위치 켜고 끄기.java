import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		int T = sc.nextInt(); //스위치 총 개수
		int [] arr = new int [T];
		
		for(int i=0; i<T; i++) {
			arr[i] = sc.nextInt();
		}
		
		int std = sc.nextInt(); //학생 수
		
		for(int j=1; j<=std; j++) {
			int gender = sc.nextInt();
			int num = sc.nextInt();
			
			if(gender ==1) { // 남학생
				for(int i=0; i<T; i++) {
					if((i+1)%num == 0) {
						if(arr[i] == 0) {
							arr[i]=1;
						}else {
							arr[i]=0;
						}
					}
				}
			}//남학생 
			
			if (gender == 2) { // 여학생
			    int left = num - 1;
			    int right = num - 1;

			    while (left >= 0 && right < T) {
			        if (arr[left] != arr[right]) {
			            break;
			        }
			        left--;
			        right++;
			    }

			    left++;
			    right--;

			    for (int i = left; i <= right; i++) {
			        arr[i] = 1 - arr[i]; // 스위치를 토글합니다
			    }

			}//여학생 
		}//성별에 따른 스위치 for문
		
		for(int i=1; i<=T; i++) {
			System.out.print(arr[i-1] + " ");
			if(i%20==0) System.out.println();
		}
		
	}//main
}//class