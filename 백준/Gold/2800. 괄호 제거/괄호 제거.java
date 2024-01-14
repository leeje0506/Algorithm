import java.io.*;
import java.util.*;

public class Main {
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        remove(s);
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        for (String str : list) {
            System.out.println(str);
        }
    }

    static void remove(String s) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> pairs = new ArrayList<>();

        // 괄호 쌍의 위치를 찾는다
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    pairs.add(stack.pop());
                    pairs.add(i);
                }
            }
        }

        // 모든 조합에 대해 괄호 쌍을 제거한다
        for (int i = 1; i < (1 << pairs.size() / 2); i++) {
            StringBuilder sb = new StringBuilder(s);
            for (int j = 0; j < pairs.size() / 2; j++) {
                if ((i & (1 << j)) > 0) {
                    sb.setCharAt(pairs.get(2 * j), ' ');
                    sb.setCharAt(pairs.get(2 * j + 1), ' ');
                }
            }
            set.add(sb.toString().replaceAll(" ", ""));
        }
    }
}
