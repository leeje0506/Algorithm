class Solution {
    public int solution(int a, int b, int c) {
        int answer = 0;
        
        for(int i=0; i<6; i++){
            // a = sc.nextInt();
            // b = sc.nextInt();
            // c = sc.nextInt();
            
            if(a != b && b !=c && c!=a){
                answer = a + b + c;
            }
            else if((a==b && b!=c) || (b==c && c!=a) || (c==a && a!=b)) {
                answer = (a+b+c)*((a*a)+(b*b)+(c*c));
            }else if(a==b && b==c) {
                answer = (a+b+c)*((a*a)+(b*b)+(c*c))*((a*a*a)+(b*b*b)+(c*c*c));
            }
        }
        
        
        return answer;
    }
}