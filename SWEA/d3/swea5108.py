'''
swea5108. 숫자 추가
'''
tc = int(input())
for t in range(1, tc+1):
    N, M, L = map(int, input().split())
    arr = list(map(int, input().split())) + [0] * M
    for _ in range(M):
        idx, item = map(int, input().split())
        i = N
        while i != idx:
            arr[i] = arr[i - 1]
            i -= 1
        arr[idx] = item
        N += 1
    print(f'#{t} {arr[L]}')