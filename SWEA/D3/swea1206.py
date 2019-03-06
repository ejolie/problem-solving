'''
1206. View

'''
def findView(arr, n):
    cnt = 0
    for i in range(2, n-2):
        if arr[i] > arr[i]
        maxHeight = max([arr[i-2], arr[i-1], arr[i+1], arr[i+2]])
        if maxHeight < arr[i]:
            cnt += arr[i] - maxHeight
    return cnt

for t in range(1, 11):
    n = int(input())
    arr = [int(i) for i in input().strip().split()]
    result = findView(arr, n)
    print(f'#{t} {result}')


'''
0 0 3 5 2 4 9 0 6 4 0 6 0 0

n : 14
0   0   3   5   2   4   9   0   6   4   0   6   0   0
0   1   2  '3'  4   5  '6'   7   8   9  10 '11'  12  13

2, 4, 6, 8 ...

- 내 왼쪽, 오른쪽이 나보다 높으면 무조건 X
- 내 왼쪽, 오른쪽 중 max 값과의 차이 계산,     

a[1] a[2] a[3] a[4] a[5]

'''