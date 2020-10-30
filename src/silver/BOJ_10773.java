package silver;

import java.io.*;
import java.util.Stack;

public class BOJ_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num != 0)
                stack.push(num);
            else
                stack.pop();
        }

        int sum = 0;
        for(int i : stack)
            sum += i;

        System.out.println(sum);

        bw.flush();
        bw.close();
    }
}
