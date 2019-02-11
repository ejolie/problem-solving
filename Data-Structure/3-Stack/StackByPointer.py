class StackByPointer:
    MAX_SIZE = 1 << 2**30  # 10억
    def __init__(self):
        self.top = -1
        self.capacity = 0
        self.items = [0] * StackByPointer.MAX_SIZE

    def push(self, item):
        self.top += 1
        self.capacity += 1
        self.items[self.top] = item

    def pop(self):
        if self.isEmpty():
            return -1
        tmp = self.top
        self.top -= 1
        self.capacity -= 1
        return self.items[tmp]

    def peek(self):
        return self.items[self.top]

    def isEmpty(self):
        return self.capacity == 0

    def size(self):
        return self.capacity
        