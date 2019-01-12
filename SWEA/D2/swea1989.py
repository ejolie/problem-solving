'''
1989. 초심자의 회문 검사 

단어를 입력 받아 회문이면 1을 출력하고, 
아니라면 0을 출력하는 프로그램을 작성하라.
'''
t = int(input())
for i in range(1, t+1):
  word = input().strip()
  word.replace(' ', '')
  isPalindrome = '1' if word == word[::-1] else '0'
  print(f'#{i} {isPalindrome}')