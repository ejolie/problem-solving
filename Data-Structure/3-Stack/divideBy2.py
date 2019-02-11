from Stack import Stack

def divideBy2(decNumber):
    s= Stack()

    while decNumber > 0:
        rem = decNumber % 2
        s.push(rem)
        decNumber //= 2

    binString = ""
    while not s.isEmpty():
        binString += str(s.pop())

    return binString

print(divideBy2(42))