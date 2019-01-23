'''
4864. 문자열 비교

두 개의 문자열 str1과 str2가 주어진다.
첫 문자열이 두번째에 존재하면 1, 존재하지 않으면 0을 출력한다.
'''
def find_string(s1, s2):
    ret = 0
    n1, n2 = len(s1), len(s2)
    for i in range(0, n2-n1+1):
        if s2[i:i+n1] == s1:
            ret = 1
            break
    return ret

tc = int(input())
for t in range(1, tc+1):
    s1 = input()
    s2 = input()
    result = find_string(s1, s2)
    print(f'#{t} {result}')