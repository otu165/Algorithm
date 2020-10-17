package silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //입력
        int n = Integer.parseInt(br.readLine());

        int matrix[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 2; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //풀이
        int rank[] = new int[n];

        for (int i = 0; i < n; i++) {
            rank[i]++;

            for (int j = 0; j < n; j++) {
                //자기자신 제외
                if (i == j) {
                    continue;
                }

                if (matrix[j][0] > matrix[i][0] && matrix[j][1] > matrix[i][1]) {
                    rank[i]++;
                }
            }
        }

        //출력
        for (int i = 0; i < n; i++) {
            System.out.print(rank[i] + " ");
        }
    }
}
