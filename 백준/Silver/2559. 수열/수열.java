

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    //K일의 온도 합의 최대가 되도록.
    public static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int [] arr = new int [N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N-K+1; i++) {
            int sum = 0;
            for (int j = i; j < i+K; j++) {
                sum += arr[j];
            }
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }//main

    //생각해보니 재귀까지도 필요없음
}
