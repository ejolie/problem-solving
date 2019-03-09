'''
1945. 간단한 소인수분해

숫자 N은 아래와 같다.
N = 2^a x 3^b x 5^c x 7^d x 11^e
N이 주어질 때 a, b, c, d, e를 출력하라.
'''
tc = int(input())
for t in range(1, tc+1):
    N = int(input())
    a, b, c, d, e = 0, 0, 0, 0, 0
    while N % 2 == 0:
    	N //= 2
    	a += 1
    while N % 3 == 0:
    	N //= 3
    	b += 1
    while N % 5 == 0:
    	N //= 5
    	c += 1
    while N % 7 == 0:
    	N //= 7
    	d += 1
    while N % 11 == 0:
    	N //= 11
    	e += 1
    print('#%d %d %d %d %d %d' % (t, a, b, c, d, e))