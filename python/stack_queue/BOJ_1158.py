''' 요세푸스 문제
시간 제한 : 2초, 메모리 제한 : 256 MB

메모리 : 32704 KB, 시간 : 100 ms
'''

from collections import deque

# 입력
N, K = map(int, input().split())

# 풀이
q = deque()
arr = [q.append(x) for x in range(1, N + 1)]
remove = []

for _ in range(N):
    q.rotate(-(K - 1))

    remove.append(q.popleft())

# 출력
if len(remove) == 1:
    print(f"<{remove[0]}>")
    exit(0)

for i in range(N):
    if i == 0:
        print("<" + str(remove[i]) + ", ", end='')
    elif i == N - 1:
        print(str(remove[i]) + ">", end='')
    else:
        print(str(remove[i]) + ", ", end='')
