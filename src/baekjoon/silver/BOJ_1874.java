package baekjoon.silver;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class BOJ_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> al = new ArrayList<>();

        for (int i = 0; i < n; i++) { // 목표 수열
            al.add(Integer.parseInt(br.readLine()));
        }

        Stack<Integer> stack = new Stack<>(); // 1 ~ n 까지의 숫자
        StringBuilder sb = new StringBuilder(); // 결과

        for (int i = 1; i <= n; i++) {
            stack.push(i);
            sb.append("+\n");

            while(!stack.isEmpty() && !al.isEmpty() && stack.peek().equals(al.get(0))) {
                stack.pop();
                al.remove(0);
                sb.append("-\n");
            }
        }

        if(! stack.isEmpty()) {
            sb.delete(0, sb.length()).append("NO\n");
        }

        System.out.println(sb);
    }
}
