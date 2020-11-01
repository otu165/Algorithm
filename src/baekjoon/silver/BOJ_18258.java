package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Queue q = new LinkedList();
        int lastValue = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String operator = st.nextToken();

            if(operator.equals("push")) { // push
                int value = Integer.parseInt(st.nextToken());
                q.offer(value);
                lastValue = value;
            }
            else if(operator.equals("pop")) {
                if(q.isEmpty())
                    sb.append("-1\n");
                else {
                    sb.append(q.poll() + "\n");
                }
            }
            else if(operator.equals("size")) {
                sb.append(q.size() + "\n");
            }
            else if(operator.equals("empty")) {
                if(q.isEmpty())
                    sb.append("1\n");
                else
                    sb.append("0\n");
            }
            else if(operator.equals("front")) {
                if(q.isEmpty())
                    sb.append("-1\n");
                else
                    sb.append(q.peek() + "\n");
            }
            else if(operator.equals("back")) {
                if(q.isEmpty())
                    sb.append("-1\n");
                else
                    sb.append(lastValue + "\n");
            }
        }

        System.out.println(sb);
    }
}