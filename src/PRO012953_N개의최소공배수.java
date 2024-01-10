import java.util.Arrays;

public class PRO012953_N개의최소공배수 {
    public static void main(String[] args) {
        int[] arr = {2, 6, 8, 14};
        System.out.println(solution(arr));
    }

    private static int solution(int[] arr) {
        Arrays.sort(arr);
        int maxNum = arr[arr.length - 1];
        int answer = 0;

        boolean flag;
        while(true) {
            flag = true;
            answer += maxNum;
            for(int n : arr) {
                if (answer % n != 0) {
                    flag = false;
                    break;
                }
            }

            if(flag) return answer;
        }
    }
}
