import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //이진탐색을 위한 정렬
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(binarySearch(arr, num)){
                sb.append("1" +"\n");
            }else{
                sb.append("0" +"\n");
            }
        }
        System.out.println(sb);
    }

    public static boolean binarySearch (int [] arr, int A){
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) /2 ;
            if(arr[mid] == A){
                return true;
            }
            if(arr[mid] < A){
                low = mid+1;
            }else{
                high = mid-1;
            }

        }
        return false;
    }

}