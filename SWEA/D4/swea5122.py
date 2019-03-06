'''
swea5122. 수열 편집
'''
tc = int(input())
for t in range(1, tc+1):
    N, M, L = map(int, input().split())
    arr = input().split() + [0] * M
    for _ in range(M):
        commands = input().split()
        idx = int(commands[1])
        if commands[0] == 'I':
            i = N
            while i != idx:
                arr[i] = arr[i - 1]
                i -= 1
            arr[idx] = commands[2]
            N += 1
        elif commands[0] == 'D':
            i = idx
            while i <= N-2:
                arr[i] = arr[i+1]
                i += 1
            N -= 1
        elif commands[0] == 'C':
            arr[idx] = commands[2]
    print(f'#{t} ', end='')
    if L > N-1: print('-1')
    else: print(arr[L])