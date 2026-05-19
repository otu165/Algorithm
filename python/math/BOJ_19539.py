import sys
input = sys.stdin.readline

# 입력
N = int(input())
arr = list(map(int, input().split()))

# 풀이
# 1.
if sum(arr) % 3 != 0:
    print("NO")
    exit(0)

# 2.
CAN = True

pair = sum(arr) // 3
count_2 = 0

for i in range(N):
    if arr[i] >= 2:
        num = arr[i] // 2  # 현재 뺄 횟수

        if count_2 + num <= pair:
            count_2 += arr[i] // 2
            arr[i] %= 2
        else:
            num = pair - count_2
            count_2 = pair

            arr[i] -= 2 * num
            break

if count_2 != pair:
    CAN = False

if sum(arr) != pair:
    CAN = False

# 출력
print("YES" if CAN else "NO")