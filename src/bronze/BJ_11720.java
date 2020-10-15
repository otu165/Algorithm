package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력
        int n = Integer.parseInt(br.readLine());
        String string = br.readLine().toString();

        //풀이
        int sum = 0;

        for (int i = 0; i < n; i++) {
            /*
            //Integer 최대값에 따라, 조건 추가 불가능
            if(Integer.parseInt(string) == 0) {
                break;
            }
             */

            sum += Integer.parseInt(string.substring(0,1));
            string = string.substring(1);
        }

        //출력
        System.out.println(sum);
    }
}
