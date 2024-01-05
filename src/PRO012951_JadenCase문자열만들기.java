public class PRO012951_JadenCase문자열만들기 {
    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed me"));
    }

    private static String solution(String s) {
        String answer = "";
        if(!s.isEmpty()) {
            answer += Character.toString(s.charAt(0)).toUpperCase();
        }

        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i - 1) == ' ')  {
                answer += Character.toString(s.charAt(i)).toUpperCase();
            } else {
                answer += Character.toString(s.charAt(i)).toLowerCase();
            }
        }

        return answer;
    }
}
