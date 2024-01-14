import java.util.HashSet;
import java.util.Set;

public class PRO131701_연속부분수열합의개수 {
    public static void main(String[] args) {
        int[] elements = {7, 9, 1, 1, 4};
        System.out.println(solution(elements));
    }

    private static int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int[][] dp = new int[elements.length + 1][elements.length + 1];
        for(int i = 1; i <= elements.length; i++) {
            for (int j = 1; j <= elements.length; j++) {
                dp[i][j] = dp[i - 1][j == 1 ? elements.length : (j - 1)] + elements[j - 1];
                set.add(dp[i][j]);
            }
        }

        /* for(int i = 1; i <= elements.length; i++) {
            for (int j = 1; j <= elements.length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        } */
        return set.size();
    }
}
