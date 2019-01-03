import sys

num = int(sys.stdin.readline())

numArr = []
while num > 10:
    numArr.append(num % 10)
    num //= 10
numArr.append(num)
numArr.sort()

retNum = sum(numArr[i]*(10**i) for i in range(len(numArr)))
print(retNum)