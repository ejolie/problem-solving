'''
boj10093. 숫자
'''
A, B = map(int, input().split())
A, B = (A, B) if A < B else (B, A)
print(f'{B-A-1}\n'+' '.join([str(n) for n in range(A+1, B)]))