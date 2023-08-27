import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main{
	
	public static List<Integer> rlist = new ArrayList<>();
	public static List<Integer> clist = new ArrayList<>();
	
    public static void main(String[] args) {
    	
//    	list에 가로, 세로 나눠서 받고.
//    	값을 정렬한 다음 i+1 - i 하면..되네~
    	
    	rlist.add(0);
        clist.add(0);
        
        Scanner sc = new Scanner (System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int T = sc.nextInt();
        
       
        for(int t=0; t< T; t++) {
        	int d = sc.nextInt();
        	int num = sc.nextInt();

        	if(d==0) {//가로로 자르기
        		rlist.add(num);
        	}if(d==1) { //세로로 자르기
        		clist.add(num);
        	}
        }
        
        rlist.add(M);  //가로번호부터 자른다 => 세로로 자르게 됨
        clist.add(N);  //세로번호부터 자른다 => 가로로 자르게 됨
        
        Collections.sort(rlist);
        Collections.sort(clist);
        
        int max =0;
        
        for(int i=1; i<rlist.size(); i++) {
        	int r = rlist.get(i) - rlist.get(i-1);
        	for(int j= 1; j<clist.size(); j++) {
        		int c = clist.get(j) - clist.get(j-1);
        		int tmp = r*c;
        		max = Math.max(max, tmp);
        	}
        }
        System.out.println(max);
        
       
    }//main
}//class
