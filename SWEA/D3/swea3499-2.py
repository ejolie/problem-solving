'''
swea3499. 퍼펙트 셔플 (D3)
'''
tc = int(input())
for t in range(1, tc+1):
    N = int(input())
    cards = input().split()
    if N % 2:
        l, r = cards[:N//2+1], cards[N//2+1:]
    else:
        l, r = cards[:N//2], cards[N//2:]
    i, j = 0, 0
    res = []
    print('#%d' % t, end=' ')
    while i < len(l) and j < len(r):
        res.append(l[i])
        res.append(r[j])
        i += 1; j += 1
    while i < len(l):
        res.append(l[i])
        i += 1
    print(' '.join(res))