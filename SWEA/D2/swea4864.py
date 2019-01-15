'''
4864. 문자열 비교

두 개의 문자열 str1과 str2가 주어진다. 
첫 문자열이 두번째에 존재하면 1, 존재하지 않으면 0을 출력한다.
'''
tc = int(input())
for t in range(1, tc+1):
    s1 = input()
    s2 = input()
    result = 1 if s1 in s2 else 0
    print(f'#{t} {result}')
        