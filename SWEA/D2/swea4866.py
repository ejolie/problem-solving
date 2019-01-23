'''
4866. 괄호검사

주어진 입력에서 괄호 {}, ()가 제대로 짝을 이뤘는지 검사하는 프로그램을 만드시오.
예를 들어 {( )}는 제대로 된 짝이지만, {( })는 제대로 된 짝이 아니다.
입력은 한 줄의 파이썬 코드일수도 있고, 괄호만 주어질 수도 있다.
정상적으로 짝을 이룬 경우 1, 그렇지 않으면 0을 출력한다.
print(‘{‘) 같은 경우는 입력으로 주어지지 않으므로 고려하지 않아도 된다.
'''
def is_pair(b1, b2):
    set1 = {'{', '}'}
    set2 = {'(', ')'}
    if b1 in set1 and b2 in set1:
        return True
    if b1 in set2 and b2 in set2:
        return True
    return False

def check_bracket(s):
    flag = 1
    stack = []
    for i in range(len(s)):
        if s[i] == '{' or s[i] == '(':
            stack.append(s[i])
        elif s[i] == '}' or s[i] == ')':
            if len(stack) == 0:
                flag = 0
                break
            top = stack.pop()
            if not is_pair(top, s[i]):
                flag = 0
                break
    if len(stack) > 0:
        flag = 0
    return flag

tc = int(input())
for t in range(1, tc+1):
    s = input()
    res = check_bracket(s)
    print(f'#{t} {res}')