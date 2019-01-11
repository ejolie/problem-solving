'''
1933. 간단한 N의 약수 

정수 N 의 약수를 오름차순으로 출력하는 프로그램을 작성하라. 
''' 
n = int(input())
arr = []
for i in range(1, n//2 + 1):
  if n % i == 0:
    arr.append(str(i))
arr.append(str(n))
print(' '.join(arr))