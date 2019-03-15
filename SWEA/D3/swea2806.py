'''
swea2806. N-Queen (D3)

N*N 보드에 N개의 퀸을 서로 다른 두 퀸이 공격하지 못하게 놓는 경우의 수는?
N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.

00 01 02 03
10 11 12 13
20 21 22 23
30 31 32 33

01, 12, 23
30, 21, 12, 03
'''
def solve(r):
    global cnt
    if r == N:
        cnt += 1
        return
    for i in range(N):
        is_possible = True
        for j in range(r):
            if board[j] == i or abs(r-j) == abs(i-board[j]):
                is_possible = False
                break
        if is_possible:
            board[r] = i
            solve(r+1)

tc = int(input())
for t in range(1, tc+1):
    N = int(input())
    board = [0] * N
    cnt = 0
    solve(0)
    print('#{} {}'.format(t, cnt))