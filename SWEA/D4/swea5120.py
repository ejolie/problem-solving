'''
swea5120. 암호
'''
class Node:
    def __init__(self, data):
        self.prev = None
        self.data = data
        self.next = None

class DoublyLinkedList:
    def __init__(self):
        self.head = Node(None)
        self.tail = Node(None)
        self.head.next = self.tail
        self.tail.prev = self.head
        self.cur = self.tail

    def add(self, item): # add item before cur
        newNode = Node(item)
        newNode.next = self.cur
        newNode.prev = self.cur.prev
        self.cur.prev.next = newNode
        self.cur.prev = newNode

    def cur_to_start(self):
        self.cur = self.head.next # init start point

    def find_insert(self, M):
        p = self.cur # start point
        for _ in range(M):
            if p == self.tail:
                p = self.head.next.next
            else: 
                p = p.next
        if p == self.tail:
            newItem = p.prev.data + self.head.next.data
        else:
            newItem = p.data + p.prev.data
        self.cur = p
        self.add(newItem)
        self.cur = self.cur.prev

    def print(self):
        p = self.tail.prev
        for _ in range(10):
            if p == self.head:
                break
            print(p.data, end=' ')
            p = p.prev
        print()

tc = int(input())
for t in range(1, tc+1):
    N, M, K = map(int, input().split())
    nums = [int(n) for n in input().split()]
    dlist = DoublyLinkedList()
    for num in nums:
        dlist.add(num)
    dlist.cur_to_start()
    for _ in range(K):
        dlist.find_insert(M)
    print(f'#{t}', end=' ')
    dlist.print()