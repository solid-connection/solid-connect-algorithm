package week03.BOJ_1477_휴게소세우기;

import java.util.*;
import java.lang.*;
import java.io.*;

class BOJ1477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] rests = new int[N + 2];
        rests[0] = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            rests[i] = Integer.parseInt(st.nextToken());
        }
        rests[N + 1] = L;
        Arrays.sort(rests); //정렬

        int left = 1;
        int right = L - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;

            for(int i = 1; i < rests.length; i++) {
                sum += (rests[i] - rests[i-1] - 1) / mid;
            }

            if(sum > M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left);
    }
}
