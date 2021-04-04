package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9494 {
    public static int index = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String string;
        String sentences[];
        while(!(string = br.readLine()).equals("0")) {
            int num = Integer.parseInt(string);
            sentences = new String[num];

            //sentences 배열 초기화
            for (int i = 0; i < num; i++) {
                sentences[i] = br.readLine();
            }

            //기준이 되는 index 초기화
            st = new StringTokenizer(sentences[0]);
            index = st.nextToken().length();

            int newIndex = 0;

            //나머지 문장 비교
            for (int i = 1; i < num; i++) {
                if(index < sentences[i].length()) {
                    sentences[i] = sentences[i].substring(index);

                    //연이은 공백인 경우 제외
                    if (sentences[i].substring(0, 1).equals(" ")) {
                        continue;
                    }

                    st = new StringTokenizer(sentences[i]);
                    index += st.nextToken().length();
                }
            }

            //index 출력 및 초기화
            System.out.println(index + 1);
            index = 0;
        }
    }
}