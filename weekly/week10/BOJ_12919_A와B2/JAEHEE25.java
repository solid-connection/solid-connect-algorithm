package week10.BOJ_12919_A와B2;

import java.io.*;
import java.util.*;

class BOJ12919 {
    static String S;
    static String T;
    static int answer = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();
        removeLetter(T);
        System.out.println(answer);
    }

    static void removeLetter(String word) {
        int len = word.length();
        if (answer == 1) return;
        if (len == S.length()) {
            if (word.equals(S)) {
                answer = 1;
            }
            return;
        }

        //1. 뒤에서 A 제거
        StringBuilder builder;
        if (word.endsWith("A")) {
            builder = new StringBuilder(word);
            builder.deleteCharAt(len - 1);
            removeLetter(builder.toString());
        }

        //2. 앞에서 B 제거하고 뒤집기
        builder = new StringBuilder(word);
        if (word.startsWith("B")) {
            builder.deleteCharAt(0);
            builder.reverse();
            removeLetter(builder.toString());
        }
    }
}
