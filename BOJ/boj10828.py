import sys

class Stack():
    def __init__(self):
        self.myList = []

    def empty(self):
        return 1 if self.myList == [] else 0

    def push(self, item):
        self.myList.append(item)
    
    def pop(self):
        return -1 if self.empty() else self.myList.pop() 

    def size(self):
        return len(self.myList)

    def top(self):
        return -1 if self.empty() else self.myList[-1]

n = int(sys.stdin.readline())
s = Stack()
for _ in range(n):
    cmd = list(sys.stdin.readline().split())
    if cmd[0] == 'push':
        s.push(int(cmd[1]))
    elif cmd[0] == 'pop':
        print(s.pop())
    elif cmd[0] == 'empty':
        print(s.empty())
    elif cmd[0] == 'size':
        print(s.size())
    elif cmd[0] == 'top':
        print(s.top())