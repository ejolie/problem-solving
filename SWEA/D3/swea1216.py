'''
1216. 회문

주어진 100x100 평면 글자판에서 가로, 세로를 모두 보아 가장 긴 회문의 길이를 구하는 문제이다.
각 칸의 들어가는 글자는 'A', 'B', 'C' 중 하나이다.
가로, 세로 각각에 대해서 직선으로만 판단한다.
'''
def find_palindrome(arr, SIZE):
    for LEN in range(100, 0, -1):           # palindrome LEN : 100 - 1
        for i in range(SIZE):               # row SIZE : 0 - 100
            for j in range(SIZE - LEN + 1): # start point
                # horizontal
                cnt = 0
                for k in range(LEN // 2):
                    if arr[i][j + k] == arr[i][LEN - 1 + j - k]:
                        cnt += 1
                    else:
                        break
                if cnt == LEN // 2:
                    return LEN

                # vertical
                cnt = 0
                for k in range(LEN // 2):
                    if arr[j + k][i] == arr[LEN - 1 + j - k][i]:
                        cnt += 1
                    else:
                        break
                if cnt == LEN // 2:
                    return LEN

tc = 10
for _ in range(1, tc+1):
    n = input()
    arr = [list(input()) for _ in range(100)]
    res = find_palindrome(arr, 100)
    print(f'#{n} {res}')