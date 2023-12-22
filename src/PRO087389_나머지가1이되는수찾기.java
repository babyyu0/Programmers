public class PRO087389_나머지가1이되는수찾기 {
    private static int n;

    public static void main(String[] args) {
        n = 10;
        System.out.println(solution());
    }

    private static int solution() {
        for(int i = 1; i < n; i++) {
            if(n % i == 1) {
                return i;
            }
        }

        return -1;
    }
}
