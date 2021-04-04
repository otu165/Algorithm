package programmers.level_2;

import java.util.Stack;

class Solution {
    int index = 0;

    public String solution(String p) {
        // 1.
        if(p.isEmpty()) {
            return p;
        }
        // 2. p to u, v
        isCorrect(p);
        String u = p.substring(0, index);
        String v = p.substring(index);

        // 3.
        if(isCorrect(u)) {
            return u + solution(v);
        }
        else { // 4.
            String temp = "(" + solution(v) + ")";

            u = u.substring(1, u.length() - 1);
            for (int i = 0; i < u.length(); i++) {
                if (String.valueOf(u.charAt(i)).equals("(")) {
                    temp = temp.concat(")");
                } else {
                    temp = temp.concat("(");
                }
            }

            return temp;
        }
    }

    public boolean isCorrect(String p) {
        Stack<Character> stack = new Stack<>();
        boolean flagC = true;

        int open = 0, close = 0; // number of (, )
        boolean flag = true;

        for (int i = 0; i < p.length(); i++) {
            if(String.valueOf(p.charAt(i)).equals("(")) {
                open++;
            }
            else {
                close++;
            }

            if(open < close) {
                flagC = false;
            }

            if(stack.isEmpty()) {
                stack.push(p.charAt(i));
            }
            else {
                if(stack.peek().equals(p.charAt(i))) {
                    stack.push(p.charAt(i));
                }
                else {
                    stack.pop();
                }
            }

            if(flag && open == close) {
                flag = false;
                index = open * 2;
            }
        }

        return flagC;
    }
}

public class PG_kakao_bracket {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution("()))((()"));
    }
}