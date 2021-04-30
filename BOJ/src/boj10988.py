from sys import stdin
def is_palindrome(s):
    if len(s) <= 1:
        return 1
    if s[0] != s[-1]:
        return 0
    return is_palindrome(s[1:-1]) 
s = stdin.readline().rstrip()
print(is_palindrome(s))