import java.util.ArrayDeque;
import java.util.Arrays;

public class PRO042885_구명보트 {
    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;

        System.out.println(solution(people, limit));
    }

    private static int solution(int[] people, int limit) {
        int answer = 0;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        Arrays.sort(people);

        for(int p : people) {
            deque.add(p);
        }

        while(!deque.isEmpty()) {
            if(deque.peekFirst() + deque.peekLast() <= limit) {
                deque.pollFirst();
            }
            deque.pollLast();
            answer++;
        }

        return answer;
    }
}
