package baekjoon.silver;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            String order = br.readLine();

            // push 명령
            if(order.contains(" ")) {
                st = new StringTokenizer(order);

                st.nextToken();
                int number = Integer.parseInt(st.nextToken());

                stack.push(number);
                continue;
            }
            // 나머지
            if(order.equals("pop")) {
                if(!stack.isEmpty())
                    bw.write(stack.pop() + "\n");
                else
                    bw.write(-1 + "\n");
            }
            else if(order.equals("size")) {
                bw.write(stack.size() + "\n");
            }
            else if(order.equals("empty")) {
                if(stack.isEmpty())
                    bw.write(1 + "\n");
                else
                    bw.write(0 + "\n");
            }
            else { // top
                if(stack.isEmpty())
                    bw.write(-1 + "\n");
                else
                    bw.write(stack.peek() + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
