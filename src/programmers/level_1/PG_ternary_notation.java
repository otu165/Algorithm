package programmers.level_1;

class S_PG_ternary_notation {
    public int solution(int n) {
        int answer = 0;

        String number = "";
        // 3진법 변환 + 뒤집기
        while(n > 0) {
            number += String.valueOf(n % 3);
            n /= 3;
        }

        // 10진법으로 변환
        for (int i = 0; i < number.length(); i++) {
            int temp = number.charAt(number.length() - (i + 1)) - '0';
            if(temp != 0) {
                answer += Math.pow(3, i) * temp;
            }
        }

        return answer;
    }
}

public class PG_ternary_notation {
    public static void main(String[] args) {
        S_PG_ternary_notation s = new S_PG_ternary_notation();
        System.out.println(s.solution(125));
    }
}
