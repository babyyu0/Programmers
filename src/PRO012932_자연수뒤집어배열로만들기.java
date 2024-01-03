import java.util.Arrays;

public class PRO012932_자연수뒤집어배열로만들기 {
    public static void main(String[] args) {
        long n = 123;
        System.out.println(Arrays.toString(solution(n)));
    }

    public static int[] solution(long n) {
        String strN = Long.toString(n);
        int[] answer = new int[strN.length()];

        for(int i = 0; i < strN.length(); i++) {
            answer[i] = strN.charAt(strN.length() - i - 1) - '0';
        }
        return answer;
    }
}
