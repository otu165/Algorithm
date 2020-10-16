package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2941 {
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //출력
        System.out.println(getCount(br.readLine()));
    }

    public static int getCount(String word) {
        String alphabet[] = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for (int i = 0; i < alphabet.length; i++) {
            //크로아티아 알파벳 카운트
            while(word.contains(alphabet[i])) {
                count++;
                word = word.replaceFirst(alphabet[i], " ");
                System.out.println("word : " + word);
            }
        }

        //남은 알파벳 카운트
        word = word.trim();
        word = word.replaceAll(" ", "");
        count += word.length();

        return count;
    }
}
