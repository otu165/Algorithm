def solution(s):  # 1,000,000 이하

    arr = [list(map(int, x.split(","))) for x in s[2:-2].split("},{")]
    arr.sort(key=lambda x: len(x))

    answer_arr = []

    for i in arr:
        for j in i:
            if j not in answer_arr:
                answer_arr.append(j)

    return answer_arr  # 500 이하


print(solution("{{4,2,3},{3},{2,3,4,1},{2,3}}"))
