'''
4873. 반복문자 지우기
'''
def solve(s):
    stack = []
    for c in s:
        if stack == [] or stack[-1] != c:
            stack.append(c)
        elif stack[-1] == c:
            stack.pop()
    return len(stack)

tc = int(input())
for t in range(1, tc+1):
    s = input()
    res = solve(s)
    print(f'#{t} {res}')