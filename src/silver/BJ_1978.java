package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1978 {
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //입력
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        //풀이
        while (st.hasMoreTokens()) {
            int number = Integer.parseInt(st.nextToken());
            boolean flag = true;

            //예외 처리
            if(number == 1) {
                continue;
            }
            else if(number == 2) {
                count++;
                continue;
            }

            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                count++;
            }
        }

        //출력
        System.out.println(count);
    }
}
