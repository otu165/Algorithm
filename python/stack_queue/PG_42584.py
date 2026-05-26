""" 주식 가격

분류 : 스택, 구현

전체 단계
ㄴ stack 에 가격이 아직 떨어지지 않은 인덱스 저장
ㄴ 현재 가격(price)이 stack[top] 가격보다 작으면 추락 기간 확정
    ㄴ 하락 확정된 인덱스의 시간 계산 후 answer 에 값 정의
ㄴ 끝까지 가격이 떨어지지 않은 인덱스들 대상으로 answer 에 값 정의

시간 복잡도
ㄴ 배열 순회 : O(n) (한 번 가격이 확정된 인덱스는 다시 반복되지 않기 때문)
ㄴ append(), pop(), top 조회 : O(1)
ㄴ 전체 : O(n)

입출력 예시
ㄴ prices = [1, 2, 3, 2, 3]
ㄴ result = [4, 3, 1, 1, 0]

"""


def solution(prices):

    n = len(prices)
    answer = [0] * n # 정답 배열

    stack = [] # 가격이 아직 **떨어지지 않은** 인덱스를 보관함

    # 가격이 떨어진 순간이 있는 인덱스 answer 만 확정
    for i, price in enumerate(prices):
        while stack and price < prices[stack[-1]]: # 가격이 떨어짐
            prev_idx = stack.pop() # 가격 추락 기간이 확정될 인덱스
            answer[prev_idx] = i - prev_idx

        stack.append(i)

    # stack 에 남아있는 인덱스(가격이 떨어지지 않은 인덱스) 대상으로 추락 기간 구하기
    while stack:
        prev_idx = stack.pop()
        answer[prev_idx] = n - prev_idx - 1

    return answer


print(solution([1, 2, 3, 2, 3]))
