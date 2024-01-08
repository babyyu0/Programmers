import java.util.Arrays;

public class PRO042842_카펫 {
    public static void main(String[] args) {
        int brown = 10;
        int yellow = 2;
        System.out.println(Arrays.toString(solution(brown, yellow)));
    }

    private static int[] solution(int brown, int yellow) {
        int size = brown + yellow;

        for(int i = size; i >= (size / i); i--) {
            // if((size / i) > i) break;
            if(size % i != 0) continue;
            // System.out.println(i + " * " + (size / i));
            if(((i - 1) + (size / i - 1)) * 2 == brown) {
                return new int[]{i, size / i};
            }
        }
        return null;
    }
}
