import java.util.Arrays;

public class PRO012916_문자열내p와y의개수 {
    public static void main(String[] args) {
        System.out.println(solution("pPoooyY"));
    }
    private static boolean solution(String s) {
        long p = 0, y = 0;
        s = s.toLowerCase();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'p') p++;
            else if(s.charAt(i) == 'y') y++;
        }
        //System.out.println("p: " + p + " / y: " + y);

        return p == y;
    }
}
