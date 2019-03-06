'''
swea5110. 수열 합치기
'''
tc = int(input())
for t in range(1, tc+1):
    N, M = map(int, input().split())
    arr = [[] for _ in range(M)]
    for i in range(M):
        arr[i] = [int(n) for n in input().split()]

    res = arr[0]
    for i in range(1, M):
        list = arr[i]
        firstNum = list[0]

        j = 0
        while j < N:
            if res[j] > firstNum:
                res = res[:j] + list + res[j:]
                break
            j += 1
        if j == N:
            res += list

    print(f'#{t}', end=' ')
    n = len(res)
    for i in range(n-1, n-10, -1):
        print(res[i], end=' ')
    print(res[n-10])