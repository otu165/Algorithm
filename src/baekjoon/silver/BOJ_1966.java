package baekjoon.silver;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TEST_CASE = Integer.parseInt(br.readLine());

        for (int i = 0; i < TEST_CASE; i++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // 문서의 개수
            int M = Integer.parseInt(st.nextToken()); // 찾고 싶은 문서의 인덱스

            Queue<Integer> q = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                q.add(Integer.parseInt(st.nextToken()));
            }

            int count = 0; // 출력 카운트
            int needToPrinted = 0; // 최대 중요도
            boolean flag = false; // 목표 문서의 출력여부

            while(true) {

                if(flag)
                    break;

                needToPrinted = q.stream().max(Integer::compareTo).get();

                // 맨 앞이 최대중요도인 경우 -> 출력(count++)
                if(q.peek() == needToPrinted) {
                    count++;
                    q.poll();

                    if(M == 0) { // 목표 대상인 경우
                        flag = true;
                    }
                    else { // 아닌 경우
                        M--;
                    }
                }
                else { // 맨 앞이 최대 중요도가 아닌경우
                    do {  // 최대 중요도까지 반복해가며 offer(q.poll()) + 목표 인덱스의 값 조정(M+-)
                        q.offer(q.poll());

                        if(M == 0) {
                            M = q.size() - 1;
                        }
                        else
                            M--;

                    } while(q.peek() != needToPrinted);
                }
            }

            System.out.println(count);
        }
    }
}


