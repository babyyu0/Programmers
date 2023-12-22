public class PRO012944_평균구하기 {
    private static int[] arr;
    public static void main(String[] args) {
        arr = new int[]{1, 2, 3, 4};
        System.out.println(solution());
    }

    private static double solution() {
        double answer = 0;

        for(int i = 0; i < arr.length; i++) {
            answer += arr[i];
        }
        return answer / arr.length;
    }
}
