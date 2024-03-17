public class Solution {
    static int answer = 0;

    public static void main(String[] args) {
        int k = 80; // 유저의 현재 피로도
        int[][] dungeons = {{80,20},{50,40},{30,10}}; // 각 던전의 [최소 필요 피로도, 소모 피로도]
        System.out.println(solution(k, dungeons)); // 결과 출력
    }

    public static int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length]; // 방문한 던전을 체크할 배열
        dfs(k, dungeons, visited, 0);
        return answer;
    }

    //DFS
    public static void dfs(int k, int[][] dungeons, boolean[] visited, int count) {
        for (int i = 0; i < dungeons.length; i++) {
            // 아직 방문하지 않았고, 현재 피로도로 탐험 가능한 던전인 경우
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true; // 던전 방문 처리
                // 던전 탐험 후 남은 피로도로 다음 던전 탐색, 탐험한 던전 수 1 증가
                dfs(k - dungeons[i][1], dungeons, visited, count + 1);
                visited[i] = false; // 백트래킹, 다른 경로 탐색을 위해 방문 처리 해제
            }
        }
        // 최대 탐험 가능한 던전 수 갱신
        answer = Math.max(answer, count);
    }
}
