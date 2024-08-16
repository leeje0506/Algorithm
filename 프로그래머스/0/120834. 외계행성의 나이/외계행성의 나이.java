class Solution {
    public String solution(int age) {
        
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        String[] alpa = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        
        if(age < 10) {
            sb.append(alpa[age % 10]);
        } else if(age < 100) {
            sb.append(alpa[age / 10]);
            sb.append(alpa[age % 10]);
        } else if(age < 1000) {
            sb.append(alpa[age / 100]);
            sb.append(alpa[(age / 10) % 10]);
            sb.append(alpa[age % 10]);
        } else if(age == 1000) {
            sb.append(alpa[1]);  // 1에 해당하는 'b'
            sb.append(alpa[0]);  // 0에 해당하는 'a'
            sb.append(alpa[0]);  // 0에 해당하는 'a'
            sb.append(alpa[0]);  // 0에 해당하는 'a'
        }
        
        answer = sb.toString();
        
        return answer;
    }
}
