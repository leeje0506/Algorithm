class Solution {
    public String solution(String my_string, int[][] queries) {
        StringBuilder sb = new StringBuilder(my_string);

        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];

            String prefix = sb.substring(0, start);
            String middle = sb.substring(start, end + 1);
            String suffix = sb.substring(end + 1);

            StringBuilder reversed = new StringBuilder(middle).reverse();
            sb = new StringBuilder(prefix + reversed + suffix);
        }

        return sb.toString();
    }
}
