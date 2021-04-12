# Greedy (탐욕법)

- 현재 상황에서 **지금 당장 좋은 것**만 고르는 방법
- 최적해를 얻을 수 있다는 **정당성**을 부여할 수 있어야 함

<br/>

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
