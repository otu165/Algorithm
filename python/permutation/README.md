# Permutation (순열)

``` Python
# 순열의 수(nPr) : n * (n - 1) * ... * (n - r + 1)

from itertools import permutations

ball_list = ['red', 'blue']
print(list(permutations(ball_list, 2)))  # [('red', 'blue'), ('blue', 'red')]
```
- 서로 다른 n 개에서 서로 다른 r 개를 선택하여 일렬로 나열하는 것
- 순서를 고려함

<br/>

## 중복 순열
``` Python
from itertools import product

ball_list = ['red', 'blue', 'yellow']
print(list(product(ball_list, repeat=3)))  

# 출력
# [
#	('red', 'red'), ('red', 'blue'), ('red', 'yellow'), 
#	('blue', 'red'), ('blue', 'blue'), ('blue', 'yellow'), 
#	('yellow', 'red'), ('yellow', 'blue'), ('yellow', 'yellow')
# ]
```

<br/>
