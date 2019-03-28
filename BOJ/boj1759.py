'''
boj1759. 암호 만들기
Backtracking 
조합, 부분 집합

input: C개의 문자들
output: 가능성 있는 암호 사전식으로 모두 출력
서로 다른 L개의 알파벳 소문자
최소 1개의 모음, 최소 2개의 자음
알파벳 오름차순

a t c i s w
a c i s t w
'''
def solve(v, cnt, pw, con, vow):
	if cnt == L:
		if vow >= 1 and con >= 2:
			print(''.join(pw))
		return
	for i in range(v, C):
		if chars[i] in 'aeiou':
			solve(i + 1, cnt + 1, pw + chars[i], con, vow + 1)
		else:
			solve(i + 1, cnt + 1, pw + chars[i], con + 1, vow)

L, C = map(int, input().split())
chars = sorted(input().split())
solve(0, 0, '', 0, 0)