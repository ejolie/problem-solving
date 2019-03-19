'''
swea4406. 모음이 보이지 않는 사람
'''
tc = int(input())
for t in range(1, tc+1):
	word = input()
	print('#{}'.format(t), end=' ')
	for c in word:
		if c not in 'aeiou':
			print(c, end='')
	print()