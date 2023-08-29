

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc= new Scanner (System.in);
		int [][] board = new int [9][9];
		
		
		for(int r=0; r<9; r++) {
			for(int c=0; c<9; c++) {
				board[r][c]=sc.nextInt();
			}
		}
		
		int max=0;int pos =0;
		int n=0;
		int m=0;
		for(n=0; n<9; n++) {
			for(m=0; m<9; m++) {
				max = Math.max(max, board[n][m]);
			}
		}
		System.out.println(max);
		
		
		for(n=0; n<9; n++) {
			for(m=0; m<9; m++) {
				if(board[n][m]==max) {
					System.out.println((n+1) + " " + (m+1));
				}
			}
		}
		
		
			
	}//main
}//class
