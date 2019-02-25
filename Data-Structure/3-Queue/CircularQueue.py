class CircularQueue:
    def __init__(self, N):
        self.front = self.rear = 0
        self.queue = [0] * N

    # 원형 큐의 삽입 연산
    def enqueue(self, item):
        if self.isFull():
            print('Queue is full.')
        else:
            self.rear = (self.rear + 1) % self.size()
            self.queue[self.rear] = item

    # 원형 큐의 삭제 연산
    def dequeue(self):
        if self.isEmpty():
            print('Queue is empty.')
        else:
            self.front = (self.front + 1) % self.size()
            return self.queue[self.front]

    def delete(self):
        if self.isEmpty():
            print('Queue is empty.')
        else:
            self.front = (self.front + 1) % self.size()
            

    def size(self):
        return len(self.queue)

    def isEmpty(self):
        return self.front == self.rear

    def isFull(self):
        return (self.rear + 1) % self.size() == self.front

    def qpeek(self):
        return self.queue[self.rear]

queue = CircularQueue(5)
queue.enqueue(1)
queue.enqueue(2)
queue.enqueue(3)
queue.enqueue(4)
queue.enqueue(5)
print(queue.dequeue())
print(queue.dequeue())
print(queue.dequeue())
print(queue.dequeue())
print(queue.dequeue())
queue.enqueue(6)
queue.enqueue(7)