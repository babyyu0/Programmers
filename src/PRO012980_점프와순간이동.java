public class PRO012980_점프와순간이동 {
    public static void main(String[] args) {
        int n = 5000;
        System.out.println(solution(n));
    }

    private static int solution(int n) {
        int answer = 0;
        while(1 < n) {
            if(n % 2 == 1) {
                answer++;
                n--;
            }
            n /= 2;
        }
        return answer + 1;
    }
}
