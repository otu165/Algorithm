package baekjoon.silver;

import java.io.*;
import java.util.Stack;

public class BOJ_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> stack_1 = new Stack<>(); // (,)
        Stack<Character> stack_2 = new Stack<>(); // [,]

        while(true) {
            String line = br.readLine();

            // 종료 조건
            if(line.equals("."))
                break;

            bw.write(isBalanced(line));
        }

        bw.flush();
        bw.close();
    }

    public static String isBalanced(String line) {
        Stack<Character> stack = new Stack<>();
        boolean flag = true;

        for(char c : line.toCharArray()) {
            if(c == '(' || c == '[')
                stack.push(c);
            else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    flag = false;
                    break;
                }
            }
            else if(c == ']') {
                if(stack.isEmpty() || stack.pop() != '[') {
                    flag = false;
                    break;
                }
            }
        }

        if(!stack.isEmpty())
            flag = false;

        return flag ? "yes\n" : "no\n";
    }
}
