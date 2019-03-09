'''
swea2001. 파리 퇴치 (D2)
'''
tc = int(input())
for t in range(1, tc+1):
    N, M = map(int, input().split())
    arr = [0] * N
    for i in range(N):
        arr[i] = [int(n) for n in input().split()]
    maxsum = 0
    for i in range(N-M+1):
        for j in range(N-M+1):
            tmpsum = 0
            for m in range(M):
                tmpsum += sum(arr[i+m][j:j+M])
            if tmpsum > maxsum:
                maxsum = tmpsum
    print('#%d %d' % (t, maxsum))