package silver;

import java.io.*;
import java.util.*;

public class BOJ_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] p = br.readLine().split(""); // 수행할 함수 R, D
            int n = Integer.parseInt(br.readLine()); // 배열의 개수

            String line = br.readLine(); // 배열에 들어갈 수의 집합
            String[] arr = line.replace("[","").replace("]","").split(",");

            // Deque 초기화
            Deque<Integer> d = new ArrayDeque<>();
            for (int j = 0; j < n; j++) {
                d.add(Integer.parseInt(arr[j]));
            }

            boolean flag = true;
            boolean direction = true; // left to right
            for(String s : p) {
                if(s.equals("R")) { // 뒤집기
                    direction = direction ? false : true;
                }
                else if(s.equals("D")) { // 앞 숫자 버리기
                    if(d.size() == 0) {
                        flag = false;
                        break;
                    }

                    if(direction) { // left 버리기
                        d.pollFirst();
                    }
                    else { // right 버리기
                        d.pollLast();
                    }
                }
            }

            if(flag) {
                int value = d.size();

                if(direction) { // index = 0 시작
                    for (int j = 0; j < value; j++) {
                        if(j == 0) {
                            sb.append("[" + d.pollFirst() + ",");
                        }
                        else if (j == value - 1) {
                            sb.append(d.pollFirst() + "]\n");
                        }
                        else {
                            sb.append(d.pollFirst() + ",");
                        }
                    }
                }
                else { // index = value - 1 시작
                    for (int j = value - 1; j >= 0; j--) {
                        if(j == value-1) {
                            sb.append("[" + d.pollLast() + ",");
                        }
                        else if(j == 0) {
                            sb.append(d.pollLast() + "]\n");
                        }
                        else {
                            sb.append(d.pollLast() + ",");
                        }
                    }
                }
            }
            else {
                sb.append("error\n");
            }
        }

        System.out.println(sb);
    }
}
