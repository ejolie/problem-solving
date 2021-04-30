import sys

class Queue():
    def __init__(self):
        self.myList = []

    def push(self, item):
        self.myList.append(item)

    def pop(self):
        return -1 if self.empty() else self.myList.pop(0)

    def size(self):
        return len(self.myList)

    def empty(self):
        return 1 if self.myList == [] else 0

    def front(self):
        return -1 if self.empty() else self.myList[0]

    def back(self):
        return -1 if self.empty() else self.myList[-1]

n = int(sys.stdin.readline())
q = Queue()
for _ in range(n):
    cmd = list(sys.stdin.readline().split())
    if cmd[0] == 'push':
        q.push(int(cmd[1]))
    elif cmd[0] == 'pop':
        print(q.pop())
    elif cmd[0] == 'empty':
        print(q.empty())
    elif cmd[0] == 'size':
        print(q.size())
    elif cmd[0] == 'front':
        print(q.front())
    elif cmd[0] == 'back':
        print(q.back())