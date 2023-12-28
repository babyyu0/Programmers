import java.util.*;

public class PRO012946_하노이의탑 {
    private static List<int[]> answer;
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(3)));
    }

    public static int[][] solution(int n) {
        answer = new ArrayList<>();
        hanoi(n, 1, 2, 3);
        return answer.toArray(new int[0][]);
    }
    
    private static void hanoi(int n, int start, int mid, int to) {
        if(n == 1) {  // 하노이탑 한 개일 때
            // System.out.println(start + " -> " + to);
            answer.add(new int[]{start, to});
            return;
        }
        hanoi(n - 1, start, to, mid);
        // System.out.println(start + " -> " + to);
        answer.add(new int[]{start, to});
        hanoi(n - 1, mid, start, to);
    }
}
