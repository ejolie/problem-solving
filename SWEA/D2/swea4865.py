'''
4865. 글자수
'''
def find_character(s1, s2):
    dic = {k:v for k in set(s1) for v in [0]*len(s1)}
    for i in range(len(s2)):
        if s2[i] in dic:
            dic[s2[i]] += 1
    return max(list(dic.values()))

tc = int(input())
for t in range(1, tc+1):
    s1 = input()
    s2 = input()
    res = find_character(s1, s2)
    print(f'#{t} {res}')