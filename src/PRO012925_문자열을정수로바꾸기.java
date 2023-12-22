public class PRO012925_문자열을정수로바꾸기 {
    private static String s;

    public static void main(String[] args) {
        String s = "1234";
        System.out.println(solution());
    }

    private static int solution() {
        return Integer.parseInt(s);
    }
}
