'''
7. Reverse Integer
'''
class Solution:
    def __init__(self):
        self.MAX_INT = 2**31 - 1
        self.MIN_INT = -2**31

    def reverse(self, x: int) -> int:
        isMinus = 1
        if x < 0:
            isMinus = -1
            x *= -1

        num = int(str(x)[::-1]) * isMinus
        if num <= self.MIN_INT or num >= self.MAX_INT:
            return 0
        return num

    def reverse2(self, x: int) -> int:
        result = 0
        while x:
            result = (result * 10) + (x % 10)
            x //= 10
            
        if num <= self.MIN_INT or num >= self.MAX_INT:
            return 0
        return result
            

solution = Solution()
print(solution.reverse(123))
print(solution.reverse(-123))
print(solution.reverse(120))