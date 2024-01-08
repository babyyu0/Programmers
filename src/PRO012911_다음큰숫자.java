public class PRO012911_다음큰숫자 {
    public static void main(String[] args) {
        int n = 78;
        System.out.println(solution(n));
    }

    private static int solution(int n) {
        int oneLen = Integer.toBinaryString(n).replace("0", "").length();

        int answer = n + 1;
        while (Integer.toBinaryString(answer).replace("0", "").length() != oneLen) {
            answer++;
        }

        return answer;
    }
}
