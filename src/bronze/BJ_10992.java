package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10992 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력
        int n = Integer.parseInt(br.readLine());

        //풀이
        if(n == 1) {
            System.out.print("*");
        }
        else {
            for (int i = 1; i <= n; i++) {
                //공백
                for (int j = n - i; j > 0; j--) {
                    System.out.print(" ");
                }

                if(i == n) { //마지막 행
                    for (int j = 1; j <= 2 * n - 1; j++) {
                        System.out.print("*");
                    }
                }
                else if (i == 1) { //첫 행
                    System.out.print("*");
                }
                else { //중간 행
                    System.out.print("*");

                    for (int j = 0; j < 2 * i - 3; j++) {
                        System.out.print(" ");
                    }

                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}
