class Stack:
    def __init__(self):
        self.stack = []

    def push(self, item):
        self.stack.append(item)

    def pop(self):
        return -1 if self.isEmpty() else self.stack.pop()

    def peek(self):
        return -1 if self.isEmpty() else self.stack[-1]

    def isEmpty(self):
        return self.stack == []

    def size(self):
        return len(self.stack)