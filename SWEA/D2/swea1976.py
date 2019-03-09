'''
swea1976. 시각 덧셈 (D2)
'''
tc = int(input())
for t in range(1, tc+1):
    h1, m1, h2, m2 = map(int, input().split())
    h3, m3 = divmod(m1 + m2, 60)
    h3 += (h1 + h2) % 12
    print('#%d %d %d' % (t, h3, m3))