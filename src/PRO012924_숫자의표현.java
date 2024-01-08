public class PRO012924_숫자의표현 {
    private static int answer;
    public static void main(String[] args) {
        int n = 15;
        System.out.println(solution(n));
    }

    private static int solution(int n) {
        dfs(1, 1, 1, n);
        return answer;
    }

    private static void dfs(int start, int end, int sum, int result) {
        //System.out.println(start + "부터 " + end + "까지 더한 " + sum);
        if (start == result) {
            //System.out.println(start + "부터 " + end + "까지 더한 " + sum + "이 " + result);
            answer++;
            return;
        } else if (sum < result) {
            dfs(start, end + 1, sum + end + 1, result);
        } else if (sum > result) {
            dfs(start + 1, end, sum - start, result);
        } else {
            //System.out.println(start + "부터 " + end + "까지 더한 " + sum + "이 " + result);
            answer++;
            dfs(start + 1, end + 1, sum - start + end + 1, result);
        }
    }
}
