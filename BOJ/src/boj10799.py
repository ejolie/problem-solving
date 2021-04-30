'''
boj10799. 쇠막대기

() : 레이저
( ( ( () () ) )
'''
from sys import stdin
st = stdin.readline().rstrip()
stack = []
stick = 0
for i in range(len(st)):
	if st[i] == '(':
		stack.append(st[i])
	else:
		if st[i-1] == '(':
			stack.pop()
			stick += len(stack)
		else:
			stack.pop()
			stick += 1
print(stick)