import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		int[] dp = new int[n];
		int[] rev = new int[n]; // 역추적 배열
		
		for (int i = 0; i < n; i++) {
			rev[i] = -1;
		}
		
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = 1;
		int maxVal = 0;
		int maxIdx = 0;
		for (int i = 0; i < n; i++) {
			int prevVal = 0;
			int prevIdx = 0;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					if (prevVal < dp[j]) {
						prevVal = dp[j];
						prevIdx = j;
					}
				}
			}
			
			dp[i] = prevVal + 1;
			if (prevVal == 0) {
				rev[i] = -1;
			}
			else {
				rev[i] = prevIdx;
			}
			
			// 최댓값 갱신
			if (maxVal < dp[i]) {
				maxVal = dp[i];
				maxIdx = i;
			}
		}
		
		sb.append(maxVal).append("\n");
		
		int idx = maxIdx;
		int[] ans = new int[maxVal];
		int ansIdx = 0;
		while (idx != -1) {
			ans[ansIdx] = arr[idx];
			idx = rev[idx];
			ansIdx++;
		}
		
		for (int i = maxVal - 1; i >= 0; i--) {
			sb.append(ans[i]).append(' ');
		}
		
		System.out.print(sb);
	}
}
