'''
swea5188. 최소합 (D2)

6 7 1 10 2
10 2 7 5 9
9 3 2 9 6
1 6 8 2 9
8 3 8 2 1

6 7 1 7 15
'''
def is_wall(x, y):
    if x < 0 or x > N-1 or y < 0 or y > N-1:
        return True
    return False

tc = int(input())
for t in range(1, tc+1):
    N = int(input())
    arr = [0] * N
    for i in range(N):
        arr[i] = list(map(int, input().split()))
    visited = [[0] * N for _ in range(N)]
    x, y = 0, 0
    total = arr[x][y]
    while (x, y) != (N-1, N-1):
        if not is_wall(x, y+1) and not is_wall(x+1, y):
            if arr[x][y+1] < arr[x+1][y]:
                total += arr[x][y+1]
                y += 1
            else:
                total += arr[x+1][y]
                x += 1
        elif is_wall(x, y+1):
            total += arr[x+1][y]
            x += 1
        elif is_wall(x+1, y):
            total += arr[x][y+1]
            y += 1
    print('#%d %d' % (t, total))