'''
boj2527. 직사각형
a 직사각형
b 선분
c 점
d 공통부분 X
'''
def solve(rec1, rec2):


for i in range(4):
    inp = list(map(int, input().split()))
    rec1 = [[inp[0],inp[1]],[inp[2],inp[3]]]
    rec2 = [[inp[4],inp[5]],[inp[6],inp[7]]]
    print(solve(rec1, rec2))