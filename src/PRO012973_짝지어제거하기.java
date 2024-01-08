import java.util.Stack;

public class PRO012973_짝지어제거하기 {
    public static void main(String[] args) {
        String s = "baabaa";
        System.out.println(solution(s));
    }

    private static int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
