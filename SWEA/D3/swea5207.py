'''
swea5207. 이진 탐색 (D3)
A : N개의 정수, 정렬된 상태
B : M개의 정수 -> A에 들어 있는 수인지 이진 탐색으로 확인
'''
def binary_search(arr, l, r, n):
    if r >= l:
        m = (l + r) // 2
        if arr[m] == n:
            return 1
        elif n < arr[m]:
            return binary_search(arr, l, m-1, n)
        else:
            return binary_search(arr, m+1, r, n)
    else:
        return 0

tc = int(input())
for t in range(1, tc+1):
    N, M = map(int, input().split())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))
    cnt = 0
    for n in B:
        cnt += binary_search(A, 0, N-1, n)
    print('#{} {}'.format(t, cnt))