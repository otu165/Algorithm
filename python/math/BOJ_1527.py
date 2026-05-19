from itertools import product

# 입력
A, B = map(int, input().split())

# 풀이
count = 0

for length in range(len(str(A)), len(str(B)) + 1):
    num_list = list(map(lambda x: ''.join(x), list(product("47", repeat=length))))
    count += len(list(filter(lambda x: A <= int(x) <= B, num_list)))

# 출력
print(count)
