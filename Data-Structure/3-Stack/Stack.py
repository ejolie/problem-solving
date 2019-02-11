class Stack:
    def __init__(self):
        self.items = []

    def push(self, item):
        self.items.append(item)

    def pop(self):
        return -1 if self.isEmpty() else self.items.pop()

    def peek(self):
        return -1 if self.isEmpty() else self.items[-1]

    def isEmpty(self):
        return self.items == []

    def size(self):
        return len(self.items)