'''
swea5431. 민석이의 과제 체크하기
'''
tc = int(input())
for t in range(1, tc+1):
    N, K = map(int, input().split())
    students = [0] * (N+1)
    submits = list(map(int, input().split()))
    print('#%d' % t, end=' ')
    for i in range(1, N+1):
        if i not in submits:
            print(i, end=' ')
    print()