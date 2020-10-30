package silver;

import java.io.*;

public class BOJ_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        // 범위 : -4,000 ~ 4,000
        // 개수 : 1 ~ 500,000
        int N = Integer.parseInt(br.readLine());

        int[] array = new int[8001];

        // 산술평균 : sum / length
        // 중앙값 : medium
        // 최빈값 : mode
        // 범위 : max - min

        int sum = 0;
        int medium = 8002;
        int mode = 8002;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // 배열 초기화
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            sum += value;
            array[value+4000]++;

            if(max < value)
                max = value;

            if(value < min)
                min = value;
        }

        int count = 0; // 중앙값 빈도 누적 수
        int modeMax = 0; // 최빈값의 최댓값

        boolean flag = false;

        for (int i = min + 4000; i <= max + 4000; i++) {
            if(array[i] == 0)
                continue;

            // 중앙값 찾기
            if (count < (N + 1) / 2) {
                count += array[i];
                medium = i - 4000;
            }

            // 최빈값 찾기
            if(modeMax < array[i]) {
                modeMax = array[i];
                mode = i - 4000;
                flag = true;
            }
            else if (modeMax == array[i] && flag) {
                mode = i - 4000;
                flag = false;
            }
        }

        System.out.println(Math.round((double)sum / N));
        System.out.println(medium);
        System.out.println(mode);
        System.out.println(max - min);

        bw.flush();
        bw.close();
    }
}
