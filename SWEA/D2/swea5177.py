'''
swea5177. 이진 힙 (D2)

이진 최소 힙
- 완전 이진 트리를 유지하기 위해 마지막 노드 뒤에 새 노드 추가
- 부모 노드 값 < 자식 노드 값
삽입 후 조건에 맞을 때까지 부모 노드와 값을 바꿈
- 노드 번호는 루트가 1번, 왼쪽에서 오른쪽으로, 더 이상 오른쪽이 없으면 다음 줄로 1씩 증가
'''
class MinHeap:
    def __init__(self, N):
        self.heap = [0] * (N+1)
        self.size = 0

    def perce_up(self, i):
        while i // 2 > 0:
            if self.heap[i] < self.heap[i // 2]: # child < parent
                self.heap[i // 2], self.heap[i] = self.heap[i], self.heap[i // 2] # swap
            i //= 2

    def insert(self, n):
        self.heap[self.size + 1] = n
        self.size += 1
        self.perce_up(self.size)

    def sum_of_pres(self):
        cnt = 0; i = self.size
        while i // 2 > 0:
            cnt += self.heap[i // 2]
            i //= 2
        return cnt

tc = int(input())
for t in range(1, tc+1):
    N = int(input())
    heap = MinHeap(N)
    nums = [int(n) for n in input().split()]
    for n in nums:
        heap.insert(n)
    print('#%d %d' % (t, heap.sum_of_pres()))