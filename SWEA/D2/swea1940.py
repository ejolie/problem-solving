'''
swea1940. 가랏! RC카! (D2)
'''
tc = int(input())
for t in range(1, tc+1):
    N = int(input())
    v, d = 0, 0
    for _ in range(N):
        comm = list(map(int, input().split()))
        if comm[0] == 0:
            d += v # s: always 1
        if comm[0] == 1: # 가속
            v += comm[1]
            d += v
        if comm[0] == 2: # 감속
            if comm[1] > v:
                v = 0
            else:
                v -= comm[1]
            d += v
    print('#%d %d' % (t, d))

