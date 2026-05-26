""" 다리를 지나는 트럭

분류 : 큐(deque), 구현, 시뮬레이션

전체 단계
ㄴ 대기 트럭을 저장하는 waiting 큐 생성
ㄴ 다리 위 트럭의 (트럭 무게, 다 건넌는 시간) 쌍을 저장하는 bridge 큐
ㄴ 다 건넌 트럭이 있으면 bridge 큐에서 제거
ㄴ 다음 트럭이 건널 수 있는 컨디션이면 waiting 큐에서 bridge 큐로 이동
ㄴ waiting, bridge 큐 모두 비어있으면 다 건넌 것이니 반복 종료

시간복잡도
ㄴ waiting 생성 : O(n)
ㄴ 큐 append, popleft() : O(1)
ㄴ 전체 : O(n + time)

입출력 예시
ㄴ bridge_length = 2, weight = 10, truck_weights = [7, 4, 5, 6]
ㄴ result = 8


"""


from collections import deque

def solution(bridge_length, weight, truck_weights):

    on_bridge_weight = 0   # 다리 위 트럭 무게

    waiting = deque(truck_weights) # 대기 트럭
    bridge = deque() # 다리를 건너는 트럭 (무게, 다 건너는 시간)

    time = 0

    # 건너는 중이거나 대기중인 트럭이 있으면 반복
    while bridge or waiting:
        time += 1

        # 다리를 다 건넌 트럭 있음?
        if bridge and bridge[0][1] <= time:
            w, _ = bridge.popleft()

            on_bridge_weight -= w

        # 다리를 건널 트럭 있음?
        if (
                waiting
                and waiting[0] + on_bridge_weight <= weight
                and len(bridge) < bridge_length
        ):
            w = waiting.popleft()

            on_bridge_weight += w
            bridge.append((w, time + bridge_length))

    return time


print(solution(2, 10, [7, 4, 5, 6]))
