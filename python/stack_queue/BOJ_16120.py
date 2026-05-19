# 입력
S = input()

# 풀이
stack = []

for s in S:
    stack.append(s)

    if ''.join(stack[-4:]) == 'PPAP':  # [-4:] == 뒤에서 4번째 원소부터 끝까지
        stack.pop()
        stack.pop()
        stack.pop()

# 출력
word = ''.join(stack)

if word == 'P' or word == 'PPAP':
    print("PPAP")
else:
    print("NP")

