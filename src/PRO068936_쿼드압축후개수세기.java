import java.util.Arrays;

public class PRO068936_쿼드압축후개수세기 {
    private static int[][] arr;
    private static int[] answer;

    public static void main(String[] args) {
        arr = new int[][]{{1, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 1, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 1, 0, 0, 1}, {0, 0, 0, 0, 1, 1, 1, 1}};
        // arr = new int[][]{{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};  // 테스트케이스
        // arr = new int[][]{{1,1},{1,1}};  // 테스트케이스
        System.out.println(Arrays.toString(solution()));
    }

    public static int[] solution() {
        answer = new int[2];
        findZip(arr.length, 0, 0);

        return answer;
    }

    private static void findZip(int split, int r, int c) {
        if (split == 1) {
            answer[arr[r][c]]++;
            return;
        }
        for (int i = 0; i < split; i += (split / 2)) {
            for (int j = 0; j < split; j += (split / 2)) {
                findZip(split / 2, r + i, c + j);
            }
        }
        boolean canZip = true;
        for (int i = 0; i < split; i++) {
            for (int j = 0; j < split; j++) {
                if (arr[r + i][c + j] != arr[r][c]) {
                    canZip = false;
                    break;
                }
            }
            if (!canZip) break;
        }

        if (canZip) {
            answer[arr[r][c]] -= 3;
        }
    }
}
