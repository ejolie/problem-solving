'''
swea1288. 새로운 불면증 치료법 (D2)
'''
tc = int(input())
for t in range(1, tc+1):
    N = int(input())
    check = 1 << 10
    k = 1
    while True:
        kN = k * N
        while kN > 0:
            n = kN % 10
            if not check & 1 << n:
                check |= 1 << n
            kN //= 10
        if check == (1 << 11) - 1:
            break
        k += 1
    print('#%d %d' % (t, k * N))