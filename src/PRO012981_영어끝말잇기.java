import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PRO012981_영어끝말잇기 {
    public static void main(String[] args) {
        int n = 3;
        String[] words = new String[] {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        System.out.println(Arrays.toString(solution(n, words)));
    }

    private static int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        set.add(words[0]);

        for(int i = 1; i < words.length; i++) {
            // 탈락 했을 경우
            if(set.contains(words[i])
                    || words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1)) {
                return new int[] {(i + 1) % n == 0 ? n : (i + 1) % n, (i / n) + 1};
            }
            set.add(words[i]);
            //System.out.println(set);
        }

        return new int[] {0, 0};
    }
}
