class LinearQueueByPointer:
    def __init__(self, N):
        self.front = self.rear = -1
        self.queue = [0] * N

    def enqueue(self, item):
        if self.isFull():
            print('Queue is full.')
        else:
            self.rear += 1
            self.queue[self.rear] = item

    def dequeue(self):
        if self.isEmpty():
            print('Queue is empty.')
        self.front += 1
        return self.queue[self.front]

    def isEmpty(self):
        return self.front == self.rear

    def isFull(self):
        return self.rear == self.size() - 1

    def size(self):
        return len(self.queue)

    def qpeek(self):
        return self.queue[self.front + 1]

queue = LinearQueueByPointer(5)
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