import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PRO086053_금과은운반하기 {
    private static int MIN_TIME, TRUCK_COUNT;
    private static int a, b;
    private static int[] g, s, w, t;

    public static void main(String[] args) {
        a = 90;
        b = 500;
        g = new int[]{70, 70, 0};
        s = new int[]{0, 0, 500};
        w = new int[]{100, 100, 2};
        t = new int[]{4, 8, 1};
        a = 10;
        b = 10;
        g = new int[]{100};
        s = new int[]{100};
        w = new int[]{10};
        t = new int[]{10};

        System.out.println(solution());
    }

    private static long solution() {
        TRUCK_COUNT = g.length;
        MIN_TIME = 0;

        int time;
        for (int i = 0; i < TRUCK_COUNT; i++) {
            time = (g[i] + s[i]) / w[i];
            time += (g[i] + s[i]) % w[i] != 0 ? 1 : 0;
            time = time * t[i] * 2 - t[i];
            System.out.println(i + "번 트럭의 자원 다 쓰는 시간: " + time);

            MIN_TIME = Math.max(time, MIN_TIME);
        }

        return twiceSearch(MIN_TIME / 2, 0, MIN_TIME);
    }

    private static long twiceSearch(int time, int start, int end) {
        System.out.println(start + "부터 " + end + "까지 탐색 안 함");
        int restG = a, restS = b;

        int canMove, restW;
        for (int i = 0; i < TRUCK_COUNT; i++) {
            canMove = (time + t[i]) / (t[i] * 2);
            System.out.println(i + "번 트럭은 " + time + "시간 동안 " + (canMove * w[i]) + "만큼 옮길 수 있다!");

            restW = canMove * w[i];

            restG -= Math.min(Math.min(restW, g[i]), a);
            restW -= Math.min(Math.min(restW, g[i]), a);
            System.out.println("남은 금: " + restG);
            System.out.println("남은 운반 개수: " + restW);
            if(0 < restW) {
                restS -= Math.min(restW, s[i]);
                restG = 0;
            }
            System.out.println("남은 은: " + restS);
        }

        System.out.println("남은 금: " + restG + " / 남은 은: " + restS);
        if (end - start == 1 || end == start) {
            return restS <= 0 ? time : time + 1;
        } else if(0 < restG || 0 < restS) {
            return twiceSearch(end - ((end - time) / 2), time, end);
        } else {
            // System.out.println((time - start) / 2 + "로 이동");
            return twiceSearch(start + (time - start) / 2, start, start + (time - start));
        }
    }
}
