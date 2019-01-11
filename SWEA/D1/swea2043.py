'''
2043. 서랍의 비밀번호

P와 K가 주어지면 K부터 시작하여 
몇 번 만에 P를 맞출 수 있는지 알아보자.
'''
p, k = map(int, input().split())
# p, k = [int(i) for i in input().split()]
print(p - k + 1)