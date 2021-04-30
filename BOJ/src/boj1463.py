'''
boj1463. 1로 만들기
'''
N = int(input())
cnt = 0
while N != 1:
	while N // 3:
		N -= 3
		cnt += 1
	while N // 2:
		N -= 2
		cnt += 1
		
