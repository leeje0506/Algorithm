import java.util.Scanner;

public class Main {
	
	//직사격형에 1 채우고 셀까?
	//int rec = (er - sr) * (ec - sc); //직사각형 면적
	
	public static int [][] board = new int [101][101];

	public static void main(String[] args) {
		int sum=0;
		Scanner scanner = new Scanner (System.in);
		
		for(int i=0; i<4; i++) {
			String [] sarr = scanner.nextLine().split(" ");
			int sr = Integer.parseInt(sarr[0]);
			int sc = Integer.parseInt(sarr[1]);
			int er = Integer.parseInt(sarr[2]);
			int ec = Integer.parseInt(sarr[3]);
			
			for(int r=sr; r<er; r++) {
				for(int c=sc; c<ec; c++) {
					board[r][c]=1;
				}
			}
		}
			
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
