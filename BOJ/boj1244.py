'''
boj1244. 스위치 켜고 끄기

- 남학생 : 스위치 번호가 학생 번호의 배수이면, 스위치 상태 반전
- 여학생 : 학생 번호와 같은 번호의 수위치를 중심으로 /
좌우가 대칭이면서 / 가장 많은 스위치를 포함하는 구간을 찾아 /
그 구간에 속한 스위치의 상태를 모두 반전
이때 구간에 속한 스위치의 개수는 항상 홀수이다.
'''
from sys import stdin

l_N = int(stdin.readline().rstrip())
lights = [0] + list(map(int, stdin.readline().rstrip().split()))
s_N = int(stdin.readline().rstrip())

for i in range(s_N):
    s, n = list(map(int, stdin.readline().rstrip().split()))
    if s == 1: # male
        for j in range(n, l_N+1, n):
            lights[j] = 1 - lights[j]
    else: # female
        for j in range(1, n):
            if 0 < n-j <= l_N and 0 < n+j <= l_N and lights[n-j] == lights[n+j]:
                lights[n-j] = lights[n+j] = 1 - lights[n-j]
            else: break
        lights[n] = 1 - lights[n]

for i in range(1, l_N+1):
    print(lights[i], end=' ')
    if i % 20 == 0:
        print()