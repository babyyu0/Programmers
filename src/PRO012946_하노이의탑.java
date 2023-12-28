import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class PRO012946_하노이의탑 {
    private static Stack<Integer>[] stacks;
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3)));
    }

    public static int[][] solution(int n) {
        hanoi(n, 1, 2, 3);
        return null;
    }
    
    private static void hanoi(int n, int start, int mid, int to) {
        if(n == 1) {
            //System.out.println("ㄲㅐㄱ");
            System.out.println(start + "에서 " + to + "로 이동");
            //System.out.println(start + "에서 " + to + "로 이동");
            return;
        }
        System.out.println(start + "에서 " + to + "로 이동");
        hanoi(n - 1, start, to, mid);
        //System.out.println(start + "에서 " + to + "로 이동");
        System.out.println("꺅");
        hanoi(n - 1, mid, start, to);
    }
}
