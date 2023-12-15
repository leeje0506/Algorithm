class Solution {
        public int solution(String s) {
            int answer = 0; // 결과를 저장할 변수
            int sum = 0; // 숫자를 더할 때 사용할 변수

            String[] arr = s.split(" "); // 문자열을 공백을 기준으로 분리하여 배열에 저장

            for (int i = 0; i < arr.length; i++) {
                if (!arr[i].equals("Z")) { // 현재 요소가 "Z"가 아닌 경우
                    sum += Integer.parseInt(arr[i]); // 숫자로 변환하여 sum에 더함
                } else {
                    sum -= Integer.parseInt(arr[i-1]); // 현재 요소가 "Z"인 경우 이전에 더한 숫자를 빼줌
                }
            }

            answer = sum; // 최종 결과를 answer에 저장

            return answer;
        }
    }