'''
boj1759. 암호 만들기

조합, 부분 집합

input: C개의 문자들
output: 가능성 있는 암호 사전식으로 모두 출력
서로 다른 L개의 알파벳 소문자
최소 1개의 모음, 최소 2개의 자음
알파벳 오름차순
'''
from sys import stdin
L, C = map(int, stdin.readline().rstrip().split())
chars = stdin.readline().rstrip().split()
