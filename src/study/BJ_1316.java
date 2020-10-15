package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_1316 {
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력
        int lineNumber = Integer.parseInt(br.readLine());
        String word[] = new String[lineNumber];

        for (int i = 0; i < lineNumber; i++) {
            word[i] = br.readLine();
        }

        //정답
        for (int i = 0; i < word.length; i++) {
            Stack<Character> stacks = new Stack<>();
            int j;

            point1 : for (j = 0; j < word[i].length(); j++) {
                char c = word[i].charAt(j);
                if (stacks.isEmpty()) {
                    stacks.push(c);
                }
                else {
                    if(stacks.peek().equals(c)) {
                        continue;
                    }
                    else {
                        if(stacks.search(c) != -1) {
                            break point1;
                        }
                        else {
                            stacks.push(c);
                        }
                    }
                }
            }

            if(j == word[i].length()) {
                count++;
            }
        }

        //출력
        System.out.println(count);
    }
}
