package week08.BOJ_13549_숨바꼭질3;

import java.util.*;
import java.lang.*;
import java.io.*;

class BOJ13549 {
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //수빈
        int K = Integer.parseInt(st.nextToken()); //동생

        int answer = Integer.MAX_VALUE;
        visit = new boolean[100001];
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(N, 0));
        while (!queue.isEmpty()) {
            Pos poll = queue.poll();
            visit[poll.x] = true;

            if (poll.x == K) {
                answer = Math.min(answer, poll.time);
            }

            if (check(poll.x + 1)) queue.add(new Pos(poll.x + 1, poll.time + 1));
            if (check(poll.x - 1)) queue.add(new Pos(poll.x - 1, poll.time + 1));
            if (check(poll.x * 2)) queue.add(new Pos(poll.x * 2, poll.time));
        }
        System.out.println(answer);
    }

    static boolean check(int value) {
        return value >= 0 && value <= 100000 && !visit[value];
    }
}

class Pos {
    int x;
    int time;

    Pos(int x, int time) {
        this.x = x;
        this.time = time;
    }
}