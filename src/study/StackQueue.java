package study;

import java.util.*;

public class StackQueue {
    public static void main(String[] args) {
        // 1. 스택 (LIFO)
        Stack<Integer> stack = new Stack<>();

        stack.push(1); // 아이템 넣기
        stack.peek(); // top 아이템 보기
        stack.pop(); // top 아이템 꺼내기

        // peek & pop 둘 다 스택이 비어있다면 오류(EmptyStackException)를 반환함
//        stack.peek();
//        stack.pop();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("index : " + stack.indexOf(2)); // 해당 값의 인덱스 반환
        System.out.println("get : " + stack.get(1)); // 1번 인덱스의 값 반환
        System.out.println();

        // 2. 큐(FIFO)
        Queue<Integer> queue = new LinkedList<>(); // 가끔, 큐 말고 ArrayList 사용이 좋을 때도 있음

        queue.add(1); // back 에 넣어짐
        queue.peek(); // front 의 값 확인
        queue.poll(); // front 의 값 제거

        // peek & poll 둘 다 큐가 비어있다면 null 을 반환함 (오류X)
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println();

        // 3. 덱(양방향 push & pop 가능)
        Deque<Integer> deque = new ArrayDeque<>();

        deque.addFirst(0); // front 에 값 넣기
        deque.peekFirst(); // front 에서 값 확인
        deque.pollFirst(); // front 에서 값 빼기

        deque.addLast(1); // back 에 값 넣기
        deque.peekLast(); // back 에서 값 확인
        deque.pollLast(); // back 에서 값 빼기

        // peek & poll 둘 다 덱이 비어있다면 null 을 반환함 (오류 X)
        System.out.println(deque.pollLast());
        System.out.println(deque.peekFirst());

        // ** 주의 사항 **
        // for(int i=0;i<stack.size() or queue.size() or deque.size(); i++) {}
        // 위와 같이 크기 만큼 반복문을 돌리는 상황에서, 반복문 내부에 pop or poll 연산이 있다면 결과가 정상적으로 도출되지 않음
        // int size = stack.size(); 와 같이 당시의 크기를 저장한 후 반복문을 돌리길 추천
    }
}
