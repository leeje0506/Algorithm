

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static List<Integer> order ;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc =1; tc<=10; tc++) {
			//원본 암호문의 길
			int N = Integer.parseInt(br.readLine());
//			int [] ori = new int [N]; 
			
			order = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
//				ori[i] = Integer.parseInt(st.nextToken());
				order.add(Integer.parseInt(st.nextToken()));
				
			}
			
			//명령어의 개수 
			int M = Integer.parseInt(br.readLine()); 
			
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<M; i++) {
				String in = st.nextToken(); //삽입
				if(in.equals("I")) {
					int idx = Integer.parseInt(st.nextToken()); //삽입 위치 : idx+1
					int num = Integer.parseInt(st.nextToken()); //몇 개의 숫자를 삽입하는지
					
					
					for(int j=0; j<num; j++) {
						order.add(idx, Integer.parseInt(st.nextToken()));
						idx++;
					}
					
				}
			}
			System.out.print("#" + tc);
			for (int t = 0; t < 10; t++) {
				System.out.print(" " + order.get(t));
			}
			System.out.println();
		}
			
		

	}//main
}//class
