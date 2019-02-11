class Queue:
    def __init__(self):
        self.items = [] # rear - front

    def enqueue(self, item):
        self.items.insert(0, item)

    def dequeue(self):
        return -1 if self.isEmpty() else self.items.pop()

    def isEmpty(self):
        return self.items == []

    def size(self):
        return len(self.items)
        