

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static LinkedList<Integer> que = new LinkedList<>();
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt =0;
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());	// 큐의 크기(1 ~ N)
		int M = Integer.parseInt(st.nextToken());	// 뽑으려는 숫자의 개수
		
		int [] arr = new int [M];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<M; i++) {			
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=N; i++) {
			que.offer(i);
		}
		
		for(int i = 0; i < M; i++) {
			// 덱에서 뽑고자 하는 숫자의 위치(index) 찾기 
			int target_idx = que.indexOf(arr[i]);
			int half_idx;
			/*
			 *  만약 현재 덱의 원소가 짝수 개라면 중간 지점을 
			 *  현재 덱의 절반 크기에서 -1 감소시킨다. 
			 *  
			 *  {1, 2, 3, 4} 일 때, 2를 중간지점으로 하면
			 *  인덱스는 1이기 때문
			 */
			if(que.size() % 2 == 0) {
				half_idx = que.size() / 2 - 1;
			}
			else {
				half_idx = que.size() / 2;
			}
			
			
			// 중간 지점 또는 중간 지점보다 원소의 위치가 앞에 있을 경우
			if(target_idx <= half_idx) {
				// idx 보다 앞에 있는 원소들을 모두 뒤로 보낸다. (2번 연산)
				for(int j = 0; j < target_idx; j++) {
					int temp = que.pollFirst();
					que.offerLast(temp);
					cnt++;
				}
			}
			else {	// 중간 지점보다 원소의 위치가 뒤에 있는 경우 
				// idx를 포함한 뒤에 있는 원소들을 모두 앞으로 보낸다. (3번 연산)
				for(int j = 0; j < que.size() - target_idx; j++) {
					int temp = que.pollLast();
					que.offerFirst(temp);
					cnt++;
				}
			
			}
			que.pollFirst();	// 연산이 끝나면 맨 앞 원소를 삭제
		}
		
		System.out.println(cnt);
		
		
	}
}