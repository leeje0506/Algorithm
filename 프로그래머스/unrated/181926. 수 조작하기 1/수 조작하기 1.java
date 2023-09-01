class Solution {
    public int solution(int n, String control) {
        int answer = 0;
        char [] arr = new char [control.length()];
        
        
        for(int i=0; i<control.length(); i++){
            arr[i]= control.charAt(i);
        }
        
        for(int i=0; i<arr.length; i++){
            if(arr[i]==('w')){
                n += 1;
            }if(arr[i]==('s')){
                n -=1;
            }if(arr[i]==('d')){
                n +=10;
            }if(arr[i]==('a')){
                n -=10;
            }
        }
        answer = n;
        return answer;
    }
}