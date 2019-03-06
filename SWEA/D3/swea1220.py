'''
swea1220. Magnetic

1: N극 성질 자성체, 2: S극 성질 자성체, N극(위) - S극(아래)

1) 테이블 아래로 사라지는 경우
- 한 column에 한 개의 자성체만 있거나
- N극쪽 최전방에 S극 자성체가 있을 때,
S극쪽 최전방에 N극 자성체가 있을 때

=> column 기준 순회하면서 거기서 row별로?
=> row 기준 순회하면서 len 사용, ?

2) 교착 상태
- column 기준 빨(1)-파(2) => 한 쌍.
- 1 1 1 2 => 한 쌍
- 1 2 1 2 => 두 쌍
stack = []
if stack == [] or stack[-1] != value
    stack.append(value)
쌍 개수 = sum(stack) / 3

'''
def solve(arr):
    res = 0
    for j in range(100):
        stack = []
        for i in range(100):
            block = arr[i][j]
            if stack == [] and block == 1: # only if 1st block of the column is red, append it to the stack.
                stack.append(block)
            elif stack != [] and stack[-1] + block == 3:  # 1) N-S, 2) S-N
                stack.append(block)
        if len(stack) < 2:
            continue
        if stack[-1] == 1:          # if last block is not blue(red), then it disappears.
            stack.pop()
        res += sum(stack) // 3
    return res

arr = [[] for _ in range(100)]
for t in range(1, 11):
    n = input()
    for i in range(100):
        arr[i] = list(map(int, input().split()))
    res = solve(arr)
    print(f'#{t} {res}')