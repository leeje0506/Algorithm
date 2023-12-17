package Coding.Codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C1096 {
    public static int [][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        board = new int [20][20];

        for (int i = 0; i <n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            board[x][y] = 1;
        }

        for (int r = 1; r <=19; r++) {
            for (int c = 1; c <=19; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }

    }
}
