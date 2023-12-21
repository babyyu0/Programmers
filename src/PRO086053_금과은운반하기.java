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
//        a = 10;
//        b = 10;
//        g = new int[]{100};
//        s = new int[]{100};
//        w = new int[]{7};
//        t = new int[]{10};

        System.out.println(solution());
    }
    private static class Truck {
        public Truck(int g, int s, int w, int t, boolean m) {
            this.g = g;
            this.s = s;
            this.w = w;
            this.t = t;
            this.m = m;
        }

        int g, s, w, t;
        boolean m;

        @Override
        public String toString() {
            return "Truck{" +
                    "g=" + g +
                    ", s=" + s +
                    ", w=" + w +
                    ", t=" + t +
                    '}';
        }
    }

        private static long solution() {
            TRUCK_COUNT = g.length;
            MIN_TIME = 999999;
            long[][][] dp = new long[TRUCK_COUNT + 2][2][10000];

            Truck[] trucks = new Truck[TRUCK_COUNT + 1];

            trucks[0] = new Truck(0, 0, 0, 0, false);
            for (int i = 0; i < TRUCK_COUNT; i++) {
                trucks[i + 1] = new Truck(g[i], s[i], w[i], t[i], false);
            }

            System.out.println(Arrays.toString(trucks));

            Arrays.sort(trucks, Comparator.comparingInt(o -> o.t));

            boolean flag = false;
            for (int i = 1; i < 10000; i++) {
                for (int j = 1; j <= TRUCK_COUNT; j++) {
                    dp[j][0][i] = dp[j][0][i - 1];
                    dp[j][1][i] = dp[j][1][i - 1];
                    dp[j][0][i] = Math.max(dp[j][0][i], dp[j - 1][0][i]);
                    dp[j][1][i] = Math.max(dp[j][1][i], dp[j - 1][1][i]);
                    if(i % trucks[j].t == 0) {
                        if(trucks[j].m) {
                            trucks[j].m = false;
                        } else {
                            trucks[j].m = true;
                            long gw = Math.min(Math.min(trucks[j].g, trucks[j].w), a - dp[j][0][i]);
                            long sw = Math.min(Math.min(trucks[j].s, trucks[j].w - gw), b - dp[j][1][i]);
                            System.out.println("gw: " + gw + ", sw: " + sw);
                            dp[j][0][i] = Math.max(dp[j][0][i], dp[j][0][i] + gw);
                            dp[j][1][i] = Math.max(dp[j][1][i], dp[j][1][i] + sw);
                        }
                    }

                    if(a <= dp[j][0][i] && b <= dp[j][1][i]) {
                        flag = true;
                        System.out.println(i + "초!");
                        break;
                    }
                }

                if(flag) break;

                System.out.println(i + " 초의 금 모인 개수 : " + dp[TRUCK_COUNT][0][i]);
                System.out.println(i + " 초의 은 모인 개수 : " + dp[TRUCK_COUNT][1][i]);
                System.out.println();
            }

            return 1;
    }
}
