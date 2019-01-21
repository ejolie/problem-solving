from sys import stdin
def is_palindrome(s):
    for i in range(len(s)//2):
        if s[i] != s[-1-i]:
            return 0
    return 1
s = stdin.readline().rstrip()
print(is_palindrome(s))