package baekjoon.silver;

import java.io.*;
import java.util.StringTokenizer;

/*
    1. 에라토스테네스의 체
        가. 제외해가며 해를 구하는 방식
 */
public class BOJ_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //입력 (1 <= m <= n <= 1,000,000)
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        //풀이
        boolean matrix[] = new boolean[n+1]; //false로 초기화됨

        //예외 처리
        matrix[1] = true;
        matrix[2] = false;

        for (int i = 2; i <= n; i++) {
            //첫 검사
            if(!matrix[i]) {
                //i의 배수 지우기
                for (int j = 2; j * i <= n; j++) {
                    matrix[j * i] = true;
                }

                //출력
                if(m <= i && !matrix[i]) {
                    bw.write(i + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
    }
}
