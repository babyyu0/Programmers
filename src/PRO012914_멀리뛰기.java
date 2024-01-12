public class PRO012914_멀리뛰기 {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(solution(n));
    }

    private static long solution(int n) {
        long[] dp = new long[n + 1];
        dp[1] = 1;
        if(n == 1) {
            return dp[n];
        }
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
            dp[i] %= 1234567;
        }

        return dp[n] % 1234567;
    }
}
