import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static StringBuilder sb = new StringBuilder();
    static int k;
    static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();

            if (input.charAt(0) == '0') {
                break;
            }

            StringTokenizer st = new StringTokenizer(input);
            k = Integer.parseInt(st.nextToken());
            numbers = new int[k];
            for (int i = 0; i < k; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            int[] result = new int[6]; //6개 숫자
            backtracking(0, 0, result);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void backtracking(int depth, int start, int[] result) {
        if (depth == 6) { //결과 출력
            for (int i = 0; i < 6; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < k; i++) {
                result[depth] = numbers[i];
                backtracking(depth + 1, i + 1, result);
        }
    }
}
