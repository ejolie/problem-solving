from typing import List

"""
735. Asteroid Collision
"""
class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        stack = [] 
        canAppend = True
        
        for a in asteroids:
            while stack and stack[-1] > 0 and a < 0:
                if stack[-1] < abs(a):
                    stack.pop()
                    continue
                elif stack[-1] == abs(a):
                    stack.pop()
                canAppend = False
                break

            if canAppend:
                stack.append(a)
            canAppend = True
        
        return stack

solution = Solution()
assert solution.asteroidCollision([5,10,-5]) == [5,10]
assert solution.asteroidCollision([8,-8]) == []
assert solution.asteroidCollision([-2,-1,1,2]) == [-2,-1,1,2]
assert solution.asteroidCollision([-2,-2,1,-1]) == [-2,-2]
assert solution.asteroidCollision([-2,1,1,-1]) == [-2,1]
assert solution.asteroidCollision([10,2,-5]) == [10]
assert solution.asteroidCollision([-2,1,1,-2]) == [-2,-2]
