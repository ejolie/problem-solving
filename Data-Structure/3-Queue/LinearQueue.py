class LinearQueue:
    def __init__(self):
        self.queue = [] # rear - front

    def enqueue(self, item):
        self.queue.insert(0, item)

    def dequeue(self):
        return -1 if self.isEmpty() else self.queue.pop()

    def isEmpty(self):
        return self.queue == []

    def size(self):
        return len(self.queue)
        