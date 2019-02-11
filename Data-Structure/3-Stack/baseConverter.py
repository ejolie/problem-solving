from Stack import Stack

def baseConverter(decNumber, base):
    digits = "0123456789ABCDEF"
    s = Stack()
    while decNumber > 0:
        rem = decNumber % base
        s.push(rem)
        decNumber //= base

    binString = ""
    while not s.isEmpty():
        binString += digits[s.pop()]

    return binString()

print(baseConverter(25,2))
print(baseConverter(25,16))