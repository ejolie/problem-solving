'''
boj1107. 리모컨
'''
from sys import stdin
N = int(stdin.readline().rstrip())
M = int(stdin.readline().rstrip())
if M: btn_set = set(map(int, stdin.readline().rstrip().split()))
cur = 100