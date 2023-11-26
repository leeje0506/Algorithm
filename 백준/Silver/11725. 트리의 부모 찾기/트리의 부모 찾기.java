import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N,a,b;
    static int[] parent;
    static boolean[] vistied;
    static ArrayList<Integer> list[];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));

        N = Integer.parseInt(br.readLine());

        parent = new int [N+1];
        vistied = new boolean[N+1];
        list = new ArrayList[N+1];

        for (int i = 0; i < N+1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);

        //아 여기 2로 시작해야하는데!
        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }
    }//main

    public static void dfs(int idx){
        vistied[idx] = true;
        for (int i : list[idx]){
            if(!vistied[i]){
                parent[i] = idx;
                dfs(i);
            }
        }
    }
}//class