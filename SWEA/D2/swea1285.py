'''
swea1285. 아름이의 돌 던지기 (D2)
'''
tc = int(input())
for t in range(1, tc+1):
    N = int(input())
    locs = list(map(int, input().split()))
    minl, cnt = 100000, 0
    for l in locs:
        if abs(l) < minl:
            minl = abs(l)
            cnt = 1
        elif abs(l) == minl:
            cnt += 1
    print('#%d %d %d' % (t, minl, cnt))