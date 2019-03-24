'''
swea5256. 이항계수 (D3)

def comb(n, r):
    if n == r or r == 0:
        return 1
    return comb(n-1, r-1) + comb(n-1, r)

70 * 70
'''
tc = int(input())
for t in range(1, tc+1):
    n, a, b = map(int, input().split())
    if a == n or b == n:
        ans = 1
    elif a == 1 or b == 1:
        ans = n
    else:
        # 4C3 = 3C3 + 3C2
        # memo = [[1], [1,1], [2c0 2c1 2c2], [3c0 3c1 3c2 3c3]]
        memo = [[0] * (i+1) for i in range(n)]
        memo[0] = [1]
        memo[1] = [1, 1]
        for i in range(2, n):
            for j in range(i+1):
                if j == 0 or j == i:
                    memo[i][j] = 1
                else:
                    memo[i][j] = memo[i-1][j-1] + memo[i-1][j]
        ans = memo[n-1][a-1] + memo[n-1][a]
    print('#{} {}'.format(t, ans))