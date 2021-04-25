''' 잃어버린 괄호
시간 제한 : 2초, 메모리 제한 : 128 MB

시간 : 72 ms, 메모리 제한 : 28776 KB
'''

# 입력
input_ = input().split('-')

# 풀이
result = 0

for i in range(len(input_)):
    try:
        n = int(input_[i])
        if i != 0:
            result -= n
        else:
            result += n
    except ValueError:
        s = input_[i].split('+')

        if i != 0:
            result -= sum(list(map(int, s)))
        else:
            result += sum(list(map(int, s)))

# 출력
print(result)
