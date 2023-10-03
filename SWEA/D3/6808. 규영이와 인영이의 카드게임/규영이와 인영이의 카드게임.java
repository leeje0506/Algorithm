import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static int T, win_cnt, lose_cnt;
	public static int [] A, B;
	public static boolean [] check; //사용 카드 체크
	public static int [] result; 
	public static boolean [] isSelect; //순열 생성시 사용 여부 체크
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//1~18까지 카드 
		
		T = Integer.parseInt(br.readLine());
		A = new int [9]; //규영카드 
		B = new int [9]; //인영카드
		result = new int [9]; //결과를 저장할 배열
		check = new boolean [18]; //tc 한번 돌때마다 초기화
//		isSelect = new boolean [9]; //순열 생성시 사용 여부 체크
//		win_cnt =0;
//		lose_cnt =0;
		
		//규영이의 카드 정보
		for(int tc=1; tc<=T; tc++) {
			check = new boolean [18]; //tc 한번 돌때마다 초기화
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<9; i++) {
				A[i] = Integer.parseInt(st.nextToken());
				
			}//규영입력끝 
//			System.out.println(Arrays.toString(A));
			
			
			//인영이가 카드를 내는 경우의 수 : 9!
			//인영이의 카드 정보 = (!규영)
			for(int i=0; i<9; i++) {
				for(int j=0; j<18; j++) {
					if(A[i]==j+1) {
						check[j] = true;
					}
				}
			}
			
			int idx=0;
			
			for(int i=0; i<18; i++) {
				if(check[i]== false) {
					B[idx++]=i+1;
				}
			}//인영입력끝
//			System.out.println(Arrays.toString(B));
//			System.out.println("____________________");
			
			isSelect = new boolean [9]; //순열 생성시 사용 여부 체크
			win_cnt =0;
			lose_cnt =0;
			
			dfs(0);
			
			System.out.println("#" + tc + " " + win_cnt + " " + lose_cnt);
			
		}//tc for

	}//main
	
	
	//카드의 승패 (순열 구현)
	public static void dfs(int cnt) {
		//기저조건
		if(cnt==9) {
			int sumA =0; //규영의 총점
			int sumB =0; //인영의 총점
			for(int i=0; i<9; i++) {
				//규영 승
				if(A[i] > result[i]) {
					sumA += A[i] + result[i];
				}
				//인영 승
				if(A[i] < result[i]) {
					sumB += A[i] + result[i];
				}
			}
			//규영이가 이기는 경우와 지는 경우의 수 카운트
			if(sumA > sumB) {
				win_cnt++;
			}else {
				lose_cnt++;
			}
			return;	
		}//기저조건 끝
		
		for(int i=0; i<9; i++) {
			if(isSelect[i]==false) {
				result[cnt] = B[i];
				isSelect[i] = true;
				dfs(cnt+1);
				isSelect[i] = false;
			}
		}
	}
}//class
