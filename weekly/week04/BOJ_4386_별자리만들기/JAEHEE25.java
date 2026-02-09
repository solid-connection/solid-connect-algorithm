package week04.BOJ_4386_별자리만들기;

import java.util.*;
import java.lang.*;
import java.io.*;

class BOJ4386 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double[][] stars = new double[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            stars[i][0] = Double.parseDouble(st.nextToken());
            stars[i][1] = Double.parseDouble(st.nextToken());
        }

        ArrayList<Edge>[] edges = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            edges[i] = new ArrayList<>();
        }

        //모든 거리 저장
        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                double dist = getDistance(stars[i][0], stars[i][1], stars[j][0], stars[j][1]);
                edges[i].add(new Edge(j, dist));
                edges[j].add(new Edge(i, dist));
            }
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[N];
        pq.add(new Edge(0, 0.0));

        double total = 0.0;
        while (!pq.isEmpty()) {
            Edge poll = pq.poll();
            if (visit[poll.num]) continue;
            visit[poll.num] = true;
            total += poll.dist;

            for (Edge next : edges[poll.num]) {
                if (!visit[next.num]) {
                    pq.add(next);
                }
            }
        }

        System.out.printf("%.2f", total);
    }

    static double getDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

}

class Edge implements Comparable<Edge> {
    int num;
    double dist;

    Edge(int num, double dist) {
        this.num = num;
        this.dist = dist;
    }

    @Override
    public int compareTo(Edge o) {
         return Double.compare(this.dist, o.dist);
    }
}

