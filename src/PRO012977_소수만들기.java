import java.util.Arrays;

public class PRO012977_소수만들기 {
    private static int MAX_NUM, answer;
    private static int[] nums;
    private static boolean[] prime;

    public static void main(String[] args) {
        nums = new int[]{1, 2, 7, 6, 4};  // 테스트케이스
        System.out.println(solution());
    }

    public static int solution() {
        Arrays.sort(nums);  // 최댓값을 찾기 위한 정렬
        MAX_NUM = nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3]; // 최대값
        prime = new boolean[MAX_NUM + 1];
        Arrays.fill(prime, true);  // 먼저 모두 소수라고 가정
        prime[0] = prime[1] = false;
        searchPrime(MAX_NUM);  // 소수 미리 찾아두기
        // printPrime(MAX_NUM);

        combination(0, 0, 0);  // 3개 더한 값 찾기
        return answer;
    }

    private static void searchPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (prime[i]) {  // 해당 수가 소수일 경우
                checkNotPrime(i);  // 소수 아닌 모든 수 구하기
            }
        }
    }

    private static void checkNotPrime(int num) {
        for (int i = 2; num * i <= MAX_NUM; i++) {
            prime[num * i] = false;  // 소수와 곱할 수 있는 수는 모두 소수 X
        }
    }

    private static void combination(int start, int count, int sum) {
        if (count == 3) {
            if (prime[sum]) answer++;  // 해당 경우가 소수일 때 경우의 수 + 1
            return;
        }

        for (int i = start; i < nums.length; i++) {  // 조합 구하기
            combination(i + 1, count + 1, sum + nums[i]);
        }
    }

    private void printPrime(int num) {
        for (int i = 2; i <= num; i++) {
            if (prime[i]) System.out.print(i + " ");
        }
        System.out.println();
    }
}
