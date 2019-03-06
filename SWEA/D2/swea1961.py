'''
swea5108. 숫자 배열 회전
'''
def solve(mat, N):
    res = [[""] * 3 for _ in range(N)]
    # 90
    j = 0
    while j <= N - 1:
        i = N - 1
        while i >= 0:
            res[j][0] += mat[i][j]
            i -= 1
        j += 1
    # 180
    i = N - 1
    while i >= 0:
        j = N - 1
        while j >= 0:
            res[N - 1 - i][1] += mat[i][j]
            j -= 1
        i -= 1
    # 270
    i = N - 1
    while i >= 0:
        j = 0
        while j <= N - 1:
            res[N - 1 - i][2] += mat[j][i]
            j += 1
        i -= 1

    for i in range(N):
        print(' '.join(res[i]))

tc = int(input())
for t in range(1, tc+1):
    N = int(input())
    mat = [[] * N for _ in range(N)]
    for i in range(N):
        mat[i] = input().split()
    print(f'#{t}')
    solve(mat, N)