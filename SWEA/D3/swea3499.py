'''
swea3499. 퍼펙트 셔플 (D3)

m = n//2 = 2
A B C D E
0 1 2 3 4

A B C / D E
A, D, B, E, C

ALAKIR ALEXSTRASZA DR-BOOM / LORD-JARAXXUS AVIANA
ALAKIR LORD-JARAXXUS ALEXSTRASZA AVIANA DR-BOOM

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
    print('#%d' % t, end=' ')
    while i < len(l) and j < len(r):
        print(l[i], end=' ')
        print(r[j], end=' ')
        i += 1; j += 1
    while i < len(l):
        print(l[i], end=' ')
        i += 1
    print()