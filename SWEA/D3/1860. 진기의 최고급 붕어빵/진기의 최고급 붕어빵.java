

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, M, K;
	static int [] time;
	static int bread, sec, idx;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); //테케 번호
		
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());//N : 자격을 얻은 사람의 수
			M = Integer.parseInt(st.nextToken());//M : 붕어빵 제조에 걸리는 시간(초)
			K = Integer.parseInt(st.nextToken());//K : M초에 만들 수 있는 붕어빵의 수
			
			time = new int [N];
			bread = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(time);
			
			sec = 1; // 초(시간)
			idx = 0; // 손님 배열의 인덱스
			boolean flag = true;

			if (time[0] == 0) {	//0초에 손님이 오면 무조건 불가능
				flag = false;
			}
			else {
				while (sec <= time[N - 1]) { // 제일 마지막에 오는 손님의 시간까지 반복
					// M초의 시간마다 K개의 붕어빵이 만들어짐
					if (sec % M == 0) {
						bread += K;
					}

					// 손님이 오면 붕어빵을 하나 준다
					if (sec == time[idx]) { // 손님이 올 시간이 됨
						while (sec == time[idx]) {	//같은 시간에 손님이 여러명 올 수 있으니 반복
							if (bread != 0) {
								bread = bread - 1; // 손님에게 붕어빵 하나를 줌
								idx++;
								if (idx >= N) {
									break;
								}
							}
							else { // 붕어빵이 없으면 불가능
								flag = false;
								break;
							}
						}
					}
					sec++;
				}
			}
					
			if (flag) {
				System.out.println("#" + tc + " " + "Possible");
			}
			else {
				System.out.println("#" + tc + " " + "Impossible");
			}
		}//tc for문		
	}//main
			
}