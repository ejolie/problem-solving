'''
swea1959. 두 개의 숫자열 (D2)
'''
tc = int(input())
for t in range(1, tc+1):
    a, b = map(int, input().split())
    arr = list(map(int, input().split()))
    brr = list(map(int, input().split()))
    if a > b:
        maxn = a; maxl = arr[:]
        minn = b; minl = brr[:]
    else:
        maxn = b; maxl = brr[:]
        minn = a; minl = arr[:]

    maxsum = 0
    for i in range(minn):
        maxsum += minl[i] * maxl[i]
    for i in range(1, maxn-minn+1):
        tmpsum = 0
        for j in range(minn):
            tmpsum += minl[j] * maxl[j+i]
        if tmpsum > maxsum:
            maxsum = tmpsum
    print('#%d %d' % (t, maxsum))