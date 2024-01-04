import java.util.Arrays;
import java.util.Comparator;

public class PRO012939_최댓값과최솟값 {
    public static void main(String[] args) {
        String s = "-2 1 3 -4";
        System.out.println(solution(s));
    }

    private static String solution(String s) {
        String[] sArr = s.split(" ");
        Arrays.sort(sArr, Comparator.comparingLong(Long::parseLong));

        return sArr[0] + " " + sArr[sArr.length - 1];
    }
}
