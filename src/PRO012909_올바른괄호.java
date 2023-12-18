public class PRO012909_올바른괄호 {
    private static String s;
    public static void main(String[] args) {
        s = "()()";  // 테스트케이스
        System.out.println(solution());
    }
    private static boolean solution() {
        boolean answer = true;

        // Stack<Character> stack = new Stack<>();
        int left = 0;
        char[] cArr = s.toCharArray();
        for (char c : cArr) {
            if(c == '(') left++;
            if(c == ')') {
                if(left == 0) {
                    answer = false;
                    break;
                } else {
                    left--;
                }
            }
        }

        if(left != 0) answer = false;
        return answer;
    }
}
