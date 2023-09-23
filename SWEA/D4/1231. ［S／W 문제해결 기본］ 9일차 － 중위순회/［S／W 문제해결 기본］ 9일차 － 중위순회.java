

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static int N, nodeNum, leftdata, rightdata;
	public static String [] alp;
	
	//중위순회
	public static void inOrder(int nodeNum) {
		//종료조건
		if(nodeNum>N) {
			return;
		}
		inOrder(nodeNum*2); //왼쪽자식 있으면 왼족자식으로 돌아
		System.out.print(alp[nodeNum]);
		inOrder(nodeNum*2+1); //오른쪽자식 있으면 오른쪽자식으로 돌아  
		
	}//inorder
	
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//tc
		for(int tc = 1; tc<=10; tc++) {
			N = Integer.parseInt(br.readLine()); //정점의 개수
			alp = new String[N+1]; //N까지 있는 배열로 생
			
			for(int i=1; i<N+1; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				
				nodeNum = Integer.parseInt(st.nextToken());
				alp[nodeNum] = st.nextToken();
//				leftdata = Integer.parseInt(st.nextToken());  //필요없음 사실  
//				rightdata = Integer.parseInt(st.nextToken());  //필요없음 사실 22 
				
			}
			System.out.print("#" + tc + " ");
			inOrder(1);
			System.out.println();
			
		}//tc for 
	}//main
}//class
