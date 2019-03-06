'''
5431. 민석이의 과제 체크하기

민석이는 교수가 되었고, 이번에 처음으로 맡은 과목에 수강생이 N명이다.
수강생들은 1번에서 N번까지 번호가 매겨져 있고,
어떤 번호의 사람이 제출했는지에 대한 목록을 받은 것이다.
과제를 제출하지 않은 사람의 번호를 오름차순으로 출력하는 프로그램을 작성하라.
'''
tc = int(input())
for t in range(1, tc+1):
    n, k = map(int, input().split())
    submits = list(map(int, input().split()))
    numbers = [i for i in range(1, n+1)]

    res = numbers[:]
    for i in range(n):
        if numbers[i] in submits:
            res[i] = ''

    s = ''
    for r in res:
        if r != '':
            s += f' {r}'
    print(f'#{t}{s}')