''' 에디터
시간 : 384ms (0.3초), 메모리 : 39620KB (512MB)
분류 : 자료구조, 스택

'''

import sys
read = sys.stdin.readline

# 입력 & 풀이
left = list(input().strip())  # cursor 기준 왼쪽
right = []  # cursor 기준 오른쪽

for _ in range(int(read())):
    command = read().strip()

    if command.startswith("P"):
        command, c = command.split()
        left.append(c)
        continue

    if command == "L" and len(left) > 0:
        right.append(left.pop())
    elif command == "D" and len(right) > 0:
        left.append(right.pop())
    elif command == "B" and len(left) > 0:
        left.pop()

# 출력
print(''.join(left + right[::-1]))
