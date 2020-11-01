package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //풀이
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String line[] = br.readLine().split(",");

            //출력
            System.out.println(Integer.parseInt(line[0]) + Integer.parseInt(line[1]));
        }
    }
}
