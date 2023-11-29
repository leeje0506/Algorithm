import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int [score.length];
        double [] arr = new double [score.length];
        double[] arr2 = new double [score.length]; //sort
        int eng=0;
        int math=0;
        double sum=0;
        
        for(int r=0; r<score.length; r++){
            sum = (score[r][0] + score[r][1])/2.0;
            arr[r] = sum;
            arr2[r] = sum;
        }
        Arrays.sort(arr2);
        
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                if(arr[i]==arr2[j]){
                     answer[i]=arr.length-j;  
                }
            }
        }
         
        
        return answer;
    }
}