''' 추월
시간 : 1472ms (~2초), 메모리 : 29200KB (~128MB)
분류 : 구현
제출 : Python3
'''

import sys
input = sys.stdin.readline

# 입력
N = int(input())
enter = [input().rstrip() for _ in range(N)]  # 진입
exit = [input().rstrip() for _ in range(N)]  # 퇴출

# 풀이
cnt = 0

for i, v in enumerate(exit):  # 나보다 느리게 퇴출한 차 중 나보다 먼저 진입한 차가 있는가?
    for j in range(enter.index(v)):
        if exit.index(enter[j]) > i:
            cnt += 1
            break

# 출력
print(cnt)
