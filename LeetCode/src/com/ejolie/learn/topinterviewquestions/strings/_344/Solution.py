'''
344. Reverse String
'''
class Solution:
    def reverseString(self, s: List[str]) -> None:
        n = len(s)
        for i in range(0, n//2):
            s[i], s[-1-i] = s[-1-i], s[i]

    def reverseString_reverse(self, s: List[str]) -> None:
        s.reverse()

    def reverseString_recursive(self, s: List[str]) -> None:
        def helper(left, right):
            if left < right:
                s[left], s[right] = s[right], s[left]
                helper(left + 1, right - 1)
        helper(0, len(s) - 1)