package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1924 {
    public static int index = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //입력(오늘 : 2007_01_01_MON)
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        //풀이
        String day[] = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        int calendar[] = new int[12];

        for (int i = 1; i <= calendar.length; i++) {
            //initiate day
            if(i == 4 || i == 6 || i == 9 || i == 11) {
                calendar[i-1] = 30;
            }
            else if (i == 2) {
                calendar[i-1] = 28;
            }
            else {
                calendar[i-1] = 31;
            }
        }

        int sumDays = y;
        if(x != 1) {
            for (int i = 0; i < x - 1; i++) {
                sumDays += calendar[i];
            }
        }

        index = sumDays % 7 == 0 ? 6 : sumDays % 7 - 1;

        //출력
        System.out.println(day[index]);
    }
}
