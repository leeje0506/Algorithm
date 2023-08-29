
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static ArrayList <Integer> list = new ArrayList <>();
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		int s = sc.nextInt();  //start
		int e = sc.nextInt();  //end
		int sum=0;
		
	    for(int i=0; i<1000; i++) {
	    	for(int j=0; j<=i; j++) {
	    		list.add(i+1);
	    		}
	    	}
	    	for(int n=s-1; n<=e-1; n++) {
	    		sum += list.get(n);
	    }
		System.out.println(sum);
		
	}//main
}//class
