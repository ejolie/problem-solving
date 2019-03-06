'''
4865. 글자수

두 개의 문자열 str1과 str2가 주어진다.
문자열 str1에 포함된 글자들이 str2에 몇 개씩 들어있는지 찾고,
그중 가장 많은 글자의 개수를 출력하는 프로그램을 만드시오.

예를 들어 str1 = “ABCA”, str2 = “ABABCA”인 경우,
str1의 A가 str2에 3개 있으므로 가장 많은 글자가 되고 3을 출력한다.
'''
def find_word(s1, s2):
    chars = [-1 for _ in range(26)]
    for i in range(len(s1)):
        chars[ ord(s1[i]) % 65 ] = 0
    for i in range(len(s2)):
        idx = ord(s2[i]) % 65
        if chars[idx] >= 0:
            chars[idx] += 1
    maxn = -1
    for c in chars:
        if c > maxn:
            maxn = c
    return maxn

tc = int(input())
for t in range(1, tc+1):
    s1 = input()
    s2 = input()
    res = find_word(s1, s2)
    print(f'#{t} {res}')