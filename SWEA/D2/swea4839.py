'''
4839. 이진탐색

'''
def binary_search(p, c):
    l = 1
    r = p
    cnt = 1
    while l <= r:
        m = (l + r) // 2
        if c == m:
            break
        elif c < m: 
            r = m
        else: 
            l = m
        cnt += 1
    return cnt

tc = int(input())
for t in range(1, tc+1):
    p, a, b = map(int, input().split())
    r1 = binary_search(p, a)
    r2 = binary_search(p, b)
    result = 0
    if r1 < r2: result = 'A'
    elif r1 > r2: result = 'B'
    print(f'#{t} {result}')