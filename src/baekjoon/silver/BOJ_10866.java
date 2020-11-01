package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            if(order.equals("push_back")) {
                int num = Integer.parseInt(st.nextToken());
                d.addLast(num);
            } else if (order.equals("push_front")) {
                int num = Integer.parseInt(st.nextToken());
                d.addFirst(num);
            } else if (order.equals("front")) {
                if(d.isEmpty()) {
                    sb.append("-1\n");
                }
                else {
                    sb.append(d.peekFirst() + "\n");
                }
            } else if (order.equals("back")) {
                if (d.isEmpty()) {
                    sb.append("-1\n");
                }
                else {
                    sb.append(d.peekLast() + "\n");
                }
            } else if (order.equals("size")) {
                sb.append(d.size() + "\n");
            } else if (order.equals("empty")) {
                if(d.isEmpty()) {
                    sb.append("1\n");
                }
                else {
                    sb.append("0\n");
                }
            } else if (order.equals("pop_front")) {
                if(d.isEmpty()) {
                    sb.append("-1\n");
                }
                else {
                    sb.append(d.pollFirst() + "\n");
                }
            } else if (order.equals("pop_back")) {
                if(d.isEmpty()) {
                    sb.append("-1\n");
                }
                else {
                    sb.append(d.pollLast() + "\n");
                }
            }
        }

        System.out.println(sb);
    }
}
