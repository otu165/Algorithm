''' Contact
시간 : 236ms (~2초), 메모리 : 33040KB (~512MB)
분류 : 정규표현식
제출 : Python3
'''

import re

for _ in range(int(input())):
    case = input().rstrip()
    pattern = re.compile('((100+1+)?((01)+)?)+')

    print("YES" if pattern.fullmatch(case) else "NO")











