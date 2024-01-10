public class PRO012985_예상대진표 {
    public static void main(String[] args) {
        int n = 8;
        int a = 4;
        int b = 7;
        System.out.println(solution(n, a, b));
    }

    private static int solution(int n, int a, int b) {
        int answer = 1;

        while(Math.abs(a - b) != 1 || Math.min(a, b) % 2 == 0) {
            //System.out.println("현재 a = " + a + ", b = " + b);
            a = (int) Math.ceil(a / 2.0);
            b = (int) Math.ceil(b / 2.0);
            answer++;
        }
        return answer + 1;
    }
}
