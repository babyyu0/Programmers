import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PRO072416_매출하락최소화 {
    private static int[] sales;
    private static List<Integer>[] teams;
    private static int teamLen, MIN;

    public static void main(String[] args) {
        /** 테스트케이스 1 */
//        int[] sales = new int[]{14, 17, 15, 18, 19, 14, 13, 16, 28, 17};
//        int[][] links = new int[][]{{10, 8}, {1, 9}, {9, 7}, {5, 4}, {1, 5}, {5, 10}, {10, 6}, {1, 3}, {10, 2}};
        /** 테스트케이스 2 */
        int[] sales = new int[]{5, 6, 5, 3, 4};
        int[][] links = new int[][]{{2, 3}, {1, 4}, {2, 5}, {1, 2}};


        System.out.println(PRO072416_매출하락최소화.solution(sales, links));
    }

    private static int solution(int[] sales, int[][] links) {
        PRO072416_매출하락최소화.sales = sales;
        PRO072416_매출하락최소화.links = links;
        teams = new ArrayList[sales.length + 1];
        for (int[] link : links) {
            if (teams[link[0]] == null) {
                teamLen++;
                teams[link[0]] = new ArrayList<>();
            }
            teams[link[0]].add(link[1]);
        }

        for (int i = 1; i <= sales.length; i++) {
            // System.out.println(i +  "팀 구성은 " + teams[i]);
            if (teams[i] == null) teams[i] = new ArrayList<>();
            teams[i].add(i);

            MIN += sales[i - 1];
        }

        findTeam(1, 0, new HashSet<>(), 0);

        return MIN;
    }

    private static void findTeam(int start, int sum, Set<Integer> selected, int count) {
        if (count == teamLen) {
            MIN = Math.min(sum, MIN);
//            System.out.println("최종 팀 구성은 " + selected);
//            System.out.println("최종 팀 합계는 " + sum);
//            System.out.println();
            return;
        }

        boolean flag;

        for (int i = start; i <= sales.length; i++) {
            if (teams[i].size() == 1) continue;

            for (int employee : teams[i]) {
                flag = selected.contains(employee);
                if (MIN <= sum + (!flag ? sales[employee - 1] : 0)) continue;
                if (!flag) selected.add(employee);
                findTeam(i + 1, sum + (!flag ? sales[employee - 1] : 0), selected, count + 1);
                if (!flag) selected.remove(employee);
            }
        }
    }
}
