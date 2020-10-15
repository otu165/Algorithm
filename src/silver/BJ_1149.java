package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1149 {
    public static int min = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //입력
        int n = Integer.parseInt(br.readLine());

        int expense[][] =  new int[n][3];
        for (int i = 0; i < expense.length; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                expense[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //풀이
        //기준이 되는 값 선정
        int flagIndex = 0, flagValue = expense[0][0];
        for (int i = 1; i < 3; i++) {
            if(expense[0][i] < flagValue) {
                flagValue = expense[0][i];
                flagIndex = i;
            }
        }
        min = flagValue;


        for (int i = 1; i < n; i++) {
            //min expense 찾기
            boolean flag = true;

            for (int j = 0; j < 3; j++) {
                if(j != flagIndex) {
                    if (flag) { //첫 실행
                        flagValue = expense[i][j];
                        flag = false;
                    }
                    else {
                        if (flagValue < expense[i][j]) {
                            flagIndex = (flagIndex == 0) ? 1 : 0;
                            min += flagValue;
                        }
                        else {
                            min += expense[i][j];
                            flagIndex = j;
                        }
                        break;
                    }
                }
            }
        }

        //출력
        System.out.println(min);
   }
}
