public class PRO012931_자릿수더하기 {
    public static void main(String[] args) {
        int n = 123;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int answer = 0;
        char[] array = Integer.toString(n).toCharArray();

        for(int i = 0; i < array.length; i++) {
            answer += array[i] - '0';
        }

        return answer;
    }
}
