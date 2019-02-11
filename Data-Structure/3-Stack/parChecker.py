from Stack import Stack

def parChecker(string):
    s = Stack()
    is_valid = True
    i = 0
    while i < len(string) and is_valid:
        symbol = string[i]
        if symbol == '(':
            s.push(symbol)
        else:
            if s.isEmpty():
                is_valid = False
            else:
                s.pop()
        i += 1
    if s.isEmpty() and is_valid:
        return True
    return False

print(parChecker('((()))'))
print(parChecker('(()'))