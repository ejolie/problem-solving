class StackByPointer:
    def __init__(self, N):
        self.top = -1
        self.capacity = 0
        self.stack = [0] * N

    def push(self, item):
        self.top += 1
        self.capacity += 1
        self.stack[self.top] = item

    def pop(self):
        if self.isEmpty():
            return -1
        tmp = self.top
        self.top -= 1
        self.capacity -= 1
        return self.stack[tmp]

    def peek(self):
        return self.stack[self.top]

    def isEmpty(self):
        return self.capacity == 0

    def size(self):
        return self.capacity
        