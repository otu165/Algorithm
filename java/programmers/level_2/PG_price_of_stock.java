package programmers.level_2;

class S_Price_of_stock {

    // return? 가격이 떨어지지 않은 기간
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            answer[i] = checkDrop(prices, prices[i], i + 1);
        }

        return answer;
    }

    // 가격이 떨어지는지 검사
    public int checkDrop(int[] arr, int price, int index) {

        boolean flag = true; // 하락 여부 검사
        int location = -1; // 하락시의 위치

        for (int i = index; i < arr.length; i++) {
            if(arr[i] < price) {
                flag = false;
                location = i;
                break;
            }
        }

        if(flag) {
            return arr.length - index;
        }
        else {
            return location - (index - 1);
        }
    }
}

public class PG_price_of_stock {
    public static void main(String[] args) {
        S_Price_of_stock s = new S_Price_of_stock();
        int[] prices = {1, 2, 3, 2, 3};

        for(int i : s.solution(prices)) {
            System.out.print(i + " ");
        }
    }
}
