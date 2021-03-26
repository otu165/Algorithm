package programmers.level_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class S_PG_marathon {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < completion.length; i++) {
            if(!participant[i].equals(completion[i])) {
                answer = participant[i];
                break;
            }
        }

        return answer.equals("") ? participant[participant.length - 1] : answer;
    }
}

public class PG_marathon {
    public static void main(String[] args) {
        S_PG_marathon s =  new S_PG_marathon();

        String[] participant = {"a", "b", "c", "a"};
        String[] completion = {"b", "a", "c"};

        System.out.println(s.solution(participant, completion));
    }
}
