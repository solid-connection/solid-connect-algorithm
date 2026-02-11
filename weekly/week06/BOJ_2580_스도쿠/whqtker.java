package ps_baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	static Vector<Coor> zeros = new Vector<>();
	static int[][] arr;

	static class Coor {
		int x;
		int y;
		
		Coor(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static void printArr() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(arr[i][j]).append(' ');
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static boolean col(int num, int x, int y) {
		for (int i = 0; i < 9; i++) {
			if (arr[x][i] == num) {
				return false;
			}
		}
		
		return true;
	}
	
	static boolean row(int num, int x, int y) {
		for (int i = 0; i < 9; i++) {
			if (arr[i][y] == num) {
				return false;
			}
		}
		
		return true;
	}
	
	static boolean square(int num, int x, int y) {
		int sx = (x / 3) * 3;
		int sy = (y / 3) * 3;
		
		for (int i = sx; i < sx + 3; i++) {
			for (int j = sy; j < sy + 3; j++) {
				if (arr[i][j] == num) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	static boolean ok(int num, int x, int y) {
		return col(num, x, y) && row(num, x, y) && square(num, x, y);
	}
	
	static void dfs(int cnt) {
		if (cnt == zeros.size()) {
			printArr();
			System.exit(0);
		}
		
		Coor cur = zeros.get(cnt);
		
		for (int i = 1; i <= 9; i++) {
			if (ok(i, cur.x, cur.y)) {
				arr[cur.x][cur.y] = i;
				
				dfs(cnt + 1);
				
				arr[cur.x][cur.y] = 0;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[9][9];
		
		for (int i = 0; i < 9; i++) {
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line);
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				if (arr[i][j] == 0) {
					zeros.add(new Coor(i, j));
				}
			}
		}
		
		dfs(0);
	}
}
