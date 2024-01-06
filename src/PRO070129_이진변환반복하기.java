import java.util.Arrays;

public class PRO070129_이진변환반복하기 {
    public static void main(String[] args) {
        String s = "110010101001";
        System.out.println(Arrays.toString(solution(s)));
    }

    private static int[] solution(String s) {
        int chCnt = 0, zeroCnt = 0;

        String tmp;
        while(!s.equals("1")) {
            tmp = "";
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '0') zeroCnt++;  // 0 세기
                else tmp += s.charAt(i);
            }
            s = tmp;

            s = Integer.toBinaryString(s.length());  // 길이를 이진수로 변환
            chCnt++;
        }
        return new int[] {chCnt, zeroCnt};
    }
}
