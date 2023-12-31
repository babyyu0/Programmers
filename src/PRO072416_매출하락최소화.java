import java.util.ArrayDeque;
import java.util.Queue;

public class PRO072416_매출하락최소화 {
    private static int[] sales;
    private static int[][] links;

    public static void main(String[] args) {
        /** 테스트케이스 1 */
        //int[] sales = new int[]{14, 17, 15, 18, 19, 14, 13, 16, 28, 17};
        //int[][] links = new int[][]{{10, 8}, {1, 9}, {9, 7}, {5, 4}, {1, 5}, {5, 10}, {10, 6}, {1, 3}, {10, 2}};
        /** 테스트케이스 2 */
        int[] sales = new int[]{5, 6, 5, 3, 4};
        int[][] links = new int[][]{{2,3}, {1,4}, {2,5}, {1,2}};


        System.out.println(PRO072416_매출하락최소화.solution(sales, links));
    }
    private static int solution(int[] sales, int[][] links) {
        PRO072416_매출하락최소화.sales = sales;
        PRO072416_매출하락최소화.links = links;
        boolean[][] teams = new boolean[sales.length + 1][sales.length + 1];
        for (int[] link : links) {
            teams[link[0]][link[1]] = true;
        }

        dfs(1, sales.length, 0);
    }

    private static void dfs(int index, int count, int sum) {
        for (int i = 1; i <= sales.length; i++) {
            if()
        }
    }
}
