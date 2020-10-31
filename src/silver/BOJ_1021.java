package silver;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;
import java.util.concurrent.DelayQueue;

public class BOJ_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 큐의 크기
        int M = Integer.parseInt(st.nextToken()); // 뽑으려는 수의 개수

        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> array = new ArrayList<>(); // 뽑으려는 수들의 위치
        for (int i = 0; i < M; i++) {
            array.add(Integer.parseInt(st.nextToken()));
        }

        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            d.add(i+1);
        }

        int count = 0; // 2, 3번 연산 횟수

        for (int i = 0; i < M; i++) {
            int mid = d.size() / 2;
            int index = 0; // 내가 찾고 싶은 수의 위치
            int goal = array.get(i);

            for(int n : d) {
                if(n == goal)
                    break;
                index++;
            }

            if(index <= mid) { // 2번 연산 수행
                while(goal != d.peekFirst()) {
                    d.addLast(d.pollFirst());
                    count++;
                }

                d.pollFirst(); // 뽑기
            }
            else { // 3번 연산 수행
                while(goal != d.peekLast()) {
                    d.addFirst(d.pollLast());
                    count++;
                }

                count++;
                d.pollLast(); //뽑기
            }
        }

        bw.write(count + "\n");

        bw.flush();
        bw.close();
    }
}
