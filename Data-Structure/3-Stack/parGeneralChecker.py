from Stack import Stack

def matches(open, close):
    opens = '([{'
    closers = ')]}'
    return opens.index(open) == closers.index(close)

def parGeneralChecker(string):
    s = Stack()
    is_valid = True
    i = 0
    while i < len(string) and is_valid:
        symbol = string[i]
        if symbol in '([{':
            s.push(symbol)
        else:
            if s.isEmpty():
                is_valid = False
            else:
                top = s.pop()
                if not matches(top, symbol):
                    is_valid = False
        i += 1
    if s.isEmpty() and is_valid:
        return True
    return False

print(parGeneralChecker('{{([][])}()}'))
print(parGeneralChecker('[{()]'))

