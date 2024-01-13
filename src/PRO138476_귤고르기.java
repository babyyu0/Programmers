import java.util.*;

public class PRO138476_귤고르기 {
    public static void main(String[] args) {
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        System.out.println(solution(k, tangerine));
    }

    private static int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for(int key : map.keySet()) {
            list.add(map.get(key));
        }
        Collections.sort(list, (o1, o2) -> Integer.compare(o2, o1));

        int i = 0;
        while(0 < k) {
            k -= list.get(i++);
            answer++;
        }

        return answer;
    }
}
