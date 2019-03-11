'''
swea1206. View
'''
def findView(arr, n):
    cnt = 0
    for i in range(2, n-2):
        maxHeight = max([arr[i-2], arr[i-1], arr[i+1], arr[i+2]])
        if maxHeight < arr[i]:
            cnt += arr[i] - maxHeight
    return cnt

for t in range(1, 11):
    n = int(input())
    arr = [int(i) for i in input().strip().split()]
    result = findView(arr, n)
    print(f'#{t} {result}')