''' 셀프 넘버
메모리 : 29028 KB, 시간 : 88 ms
'''


def get_self_number(n):
    global count

    s = n

    while n > 0:
        s += n % 10
        n //= 10

    return s


# 풀이 & 출력
count = 0
arr = [x for x in range(10001)]

for i in arr:
    now = i

    while True:
        sn = get_self_number(now)

        if sn > 10000:
            break
        elif arr[sn] != 0:
            arr[sn] = 0
        else:
            break

        now = sn

for i in arr:
    if i != 0:
        print(i)
