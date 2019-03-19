'''
swea4047. 영준이의 카드 카운팅
'''
tc = int(input())
for t in range(1, tc+1):
	dic = {'S':[], 'D':[], 'H':[], 'C':[]}
	s = input()
	ans = ''
	for i in range(len(s)//3):
		n = int(s[i*3+1:(i+1)*3])
		if n in dic[s[i*3]]:
			ans = 'ERROR'
			break
		else:
			dic[s[i*3]].append(n)
	if ans == '':
		for k in dic:
			ans += f'{13 - len(dic[k])} '
	print('#{} {}'.format(t, ans))