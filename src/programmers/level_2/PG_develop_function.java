package programmers.level_2;

import java.util.*;

class S_PG_develop_function {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();

        // 작업 리스트
        ArrayList<Integer> p = new ArrayList<>();
        for (int i = progresses.length - 1; i >= 0; i--) {
            p.add(progresses[i]);
        }

        // 속도 리스트
        ArrayList<Integer> s = new ArrayList<>();
        for (int i = speeds.length - 1; i >= 0; i--) {
            s.add(speeds[i]);
        }

        // 작업 시작
        while(p.size() > 0) {
            int end = makeFirstProgressEnd(p, s); // 완료된 작업의 개수

            System.out.println(p);

            for (int i = 1; i <= end; i++) {
                p.remove(p.size() - 1);
                s.remove(s.size() - 1);
            }

            result.add(end);
        }

        int[] array = new int[result.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = result.get(i);
        }

        return array;
    }

    public int makeFirstProgressEnd(ArrayList<Integer> p, ArrayList<Integer> s) {
        while(p.get(p.size() - 1) < 100) { // 첫 번째 작업이 완료되면 종료
            for (int i = p.size() - 1; i >= 0; i--) {
                p.set(i, p.get(i) + s.get(i));
            }
        }

        int count = 1;
        for (int i = p.size() - 2; i >=0; i--) {
            if(p.get(i) < 100)
                break;
            count++;
        }

        return count;
    }
}

public class PG_develop_function {
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        S_PG_develop_function s = new S_PG_develop_function();

        for(int num : s.solution(progresses, speeds)) {
            System.out.print(num + " ");
        }
    }
}
