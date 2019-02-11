'''
swea1210. Ladder1
'''
arr = [[0] * 100 for _ in range(100)]   # init arr

def check_dir(Y, X):
    if X - 1 > -1 and arr[Y][X - 1] == 1:       # turn left
        return 2
    elif X + 1 < 100 and arr[Y][X + 1] == 1:    # turn right
        return 1
    elif Y - 1 > -1 and arr[Y - 1][X] == 1:     # go up
        return 0

def find_start_from(endX):
    Y, X = 99, endX
    dy = [-1, 0, 0]
    dx = [0, 1, -1]
    while Y > 0:
        arr[Y][X] = -1  # check visited node
        dir_stat = check_dir(Y, X)  # 0: up, 1: right, 2: left
        Y += dy[dir_stat]
        X += dx[dir_stat]
    return X

for _ in range(10):
    n = int(input())
    endX = 0
    for i in range(100):
        row = list(map(int, input().split()))
        for j in range(100):
            num = row[j]
            if num == 2:
                endX = j
            arr[i][j] = num

    res = find_start_from(endX)
    print(f'#{n} {res}')

