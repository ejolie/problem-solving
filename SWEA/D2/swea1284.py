'''
swea1284. 수도 요금 경쟁 (D2)
'''
tc = int(input())
for t in range(1, tc+1):
    p, q, r, s, w = map(int, input().split())
    asum = w * p
    bsum = q
    if w > r:
        bsum += s * (w-r)
    print('#%d' % t, end=' ')
    print(asum if asum < bsum else bsum)