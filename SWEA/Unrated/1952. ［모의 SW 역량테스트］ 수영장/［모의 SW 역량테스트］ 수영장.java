import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int []plan = new int[12]; //12월 정보 받을 배열
	static int day, month, three, year; //이용권의 가격
	static int cost = year; // 초기값 1년 가격 
	static int min ; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		//이용권 가격 입력 받기 
		plan = new int [12];
		
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			day = Integer.parseInt(st.nextToken());
			month = Integer.parseInt(st.nextToken());
			three = Integer.parseInt(st.nextToken());
			year = Integer.parseInt(st.nextToken());
			
			//12개월 이용 계획 입력 받기 
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}//12개월입력 
					
			
			min = year;
			price(0,0);
			System.out.println("#" + tc + " " + min);
		}//tc for
		
	}//main
	
	
	public static void price (int mon, int cost) {
		
		//12개월을 넘는 경
		if(mon >=12) {
			min = Math.min(min, cost);
			return;
		}
		
		
		if(plan[mon] == 0 ) { //이용계획이 없다
			price(mon+1, cost); //다음 달로.
		}
		else {
			price (mon+1, cost+(plan[mon]*day));
			price (mon+1, cost+month);
			price (mon+3, cost+three);
			price (mon+12, cost+year);
		}
	}//price
	
	
}//class
