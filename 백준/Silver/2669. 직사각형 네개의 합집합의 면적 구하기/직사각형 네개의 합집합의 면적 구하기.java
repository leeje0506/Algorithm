

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int [][] board = new int [101][101];
		
		for(int t=0; t<4; t++) {
			String [] str = sc.nextLine().split(" ");
			int x1 = Integer.parseInt(str[0]);
			int y1= Integer.parseInt(str[1]);
			int x2 = Integer.parseInt(str[2]);
			int y2 = Integer.parseInt(str[3]);
			
			for(int r=x1; r<x2; r++) {
				for(int c=y1; c<y2; c++) {
					board[r][c] =1;
				}
			}
		}
		int sum=0;
		for(int r=1; r<100; r++) {
			for(int c=1; c<100; c++) {
				if(board[r][c]==1) {
					sum += board[r][c];
				}
			}
		}			
		System.out.println(sum);
	}//main
}//class
