'''
swea5204. 병합 정렬 (D3)

- 왼쪽 마지막 원소가 오른쪽 마지막 원소보다 큰 경우의 수
  = 오른쪽 마지막 원소가 먼저 복사되는 경우의 수
- 정렬이 끝난 리스트 L에서 L[N//2] 원소
'''
def merge_sort(arr):
    if len(arr) <= 1:
        return arr
    m = len(arr) // 2
    left = merge_sort(arr[:m])
    right = merge_sort(arr[m:])
    return merge(left, right, arr)

def merge(left, right, arr):
    global cnt
    i, j, k = 0, 0, 0
    if left[len(left) - 1] > right[len(right) - 1]:
        cnt += 1
    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            arr[k] = left[i]
            i += 1
        else:
            arr[k] = right[j]
            j += 1
        k += 1
    while i < len(left):
        arr[k] = left[i]
        i += 1
        k += 1
    while j < len(right):
        arr[k] = right[j]
        j += 1
        k += 1
    return arr

tc = int(input())
for t in range(1, tc+1):
    N = int(input())
    arr = list(map(int, input().split()))
    cnt = 0
    merge_sort(arr)
    print('#{} {} {}'.format(t, arr[N//2], cnt))