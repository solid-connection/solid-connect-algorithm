package stduy.week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ10828 {
	static int[] stack = new int[10001];
	static int size;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			
			switch (input) {
			    case "push" :
				    push(Integer.parseInt(st.nextToken()));
				    break;
			    case "pop" :
				    sb.append(pop()).append("\n");
				    break;
			    case "size" :
				    sb.append(size()).append("\n");
				    break;
			    case "empty" :
				    sb.append(empty()).append("\n");
				    break;
			    case "top" :
				    sb.append(top()).append("\n");
				    break;
			}
		}
		System.out.println(sb);
	}
	
	public static void push(int num) {
		stack[size++] = num;
	}
	
	public static int pop() {
		if (size == 0) return -1;
		else {
			int pop = stack[size - 1];
			size--;
			return pop;
		}
	}
	
	public static int size() {
		return size;
	}
	
	public static int empty() {
		if (size == 0) return 1;
		return 0;
	}
	
	public static int top() {
		if (size == 0) return -1;
		return stack[size - 1];
	}

}
