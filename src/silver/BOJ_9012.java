package silver;

import java.io.*;
import java.util.Stack;

public class BOJ_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            char[] array = br.readLine().toCharArray();

            bw.write(isVPS(array) ? "YES\n" : "NO\n");
        }

        bw.flush();
        bw.close();
    }

    public static boolean isVPS(char[] array) {
        Stack<Character> stack = new Stack<>();
        int open = 0, close = 0;

        for (int i = 0; i < array.length; i++) {
            // 괄호 방향 조사
            if(String.valueOf(array[i]).equals("("))
                open++;
            else
                close++;

            if(open < close)
                return false;

            if(stack.isEmpty()) {
                stack.push(array[i]);
            }
            else {
                if(stack.peek().equals(array[i]))
                    stack.push(array[i]);
                else
                    stack.pop();
            }
        }

        if(open == close && stack.isEmpty())
            return true;
        else
            return false;
    }
}
