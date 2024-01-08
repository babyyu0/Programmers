public class PRO012945_피보나치수 {
    private static int[] fiboNums;
    public static void main(String[] args) {
        int n = 3;
        System.out.println(solution(n));
    }

    private static int solution(int n) {
        fiboNums = new int[n + 1];
        fiboNums[1] = 1;

        return fibo(n) % 1234567;
    }
    private static int fibo(int n) {
        if(n == 0) {
            return 0;
        } else if (fiboNums[n] != 0) {
            return fiboNums[n];
        } else {
            return fiboNums[n] = (fibo(n - 2) + fibo(n - 1)) % 1234567;
        }
    }
}
