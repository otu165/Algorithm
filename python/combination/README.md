# Combination (조합)

``` Python
# 조합의 수(nCr) : nPr / r!

from itertools import combinations

ball_list = ['red', 'blue']
print(list(combinations(ball_list, 2)))  # [('red', 'blue')]
```
- 서로 다른 n 개에서 순서에 상관 없이 서로 다른 r 개를 선택하는 것

<br/>

## 중복 조합
``` Python
from itertools import combinations_with_replacement as cwr

ball_list = ['red', 'blue', 'yellow']
print(list(cwr(ball_list, 2)))

# 출력
# [
#	('red', 'red'), ('red', 'blue'), ('red', 'yellow'), 
#	('blue', 'blue'), ('blue', 'yellow'), 
#	('yellow', 'yellow')
# ]
```
<br/>