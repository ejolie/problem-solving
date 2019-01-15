'''
4836. 색칠하기

'''
def paintCanvas(arr, n):
    canvas = [[0] * 10 for i in range(10)]
    for i in range(n):
        for j in range(arr[i][1], arr[i][3]+1):
            for k in range(arr[i][0], arr[i][2]+1):
                canvas[j][k] += arr[i][4]
    cnt = 0
    for i in range(10):
        for j in range(10):
            if canvas[i][j] == 3:
                cnt += 1
    return cnt

tc = int(input())
for t in range(1, tc+1):
    n = int(input())
    arr = []
    for i in range(n):
        arr.append([int(i) for i in input().split()])
    result = paintCanvas(arr, n)
    print(f'#{t} {result}')