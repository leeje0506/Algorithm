import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int [] cnt = new int [10001];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            cnt[num]++;
        }

        for (int i = 0; i < cnt.length; i++) {
            while(cnt[i] > 0){
                sb.append(i).append("\n");
                //순회하면서 카운트 줄여주기
                cnt[i]--;
            }
        }

        System.out.print(sb);
    }

}