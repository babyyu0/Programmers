import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PRO086053_금과은운반하기 {
    private static int TRUCK_COUNT;
    private static int a, b;
    private static int[] g, s, w, t;

    public static void main(String[] args) {
        a = 90;
        b = 500;
        g = new int[]{70, 70, 0};
        s = new int[]{0, 0, 500};
        w = new int[]{100, 100, 2};
        t = new int[]{4, 8, 1};
//        a = 10;
//        b = 10;
//        g = new int[]{100};
//        s = new int[]{100};
//        w = new int[]{7};
//        t = new int[]{10};

        System.out.println(solution());
    }

    private static long solution() {
        TRUCK_COUNT = g.length;
        return twiceSearch(0, Integer.MAX_VALUE);
    }

    private static long twiceSearch(long low, long high) {
        long time = (low + high) / 2L;
        // System.out.println(low + "부터 " + high + "의 반");
        long restG = a, restS = b, restAll = a + b;


        long canMove, restW;
        for (int i = 0; i < TRUCK_COUNT; i++) {
            canMove = (time + t[i]) / (t[i] * 2L);
            restW = Math.min(canMove * w[i], g[i] + s[i]);

            restAll -= restW;
            restG -= Math.min(restW, g[i]);
            restS -= Math.min(restW, s[i]);
        }

        if(restG <= 0 && restS <= 0 && restAll <= 0) {
            if(high <= (low + 1)) return time;
            return twiceSearch(low, time);
        } else {
            if(high <= (low + 1)) return high;
            return twiceSearch(time, high);
        }
    }
}
