
"""
278. First Bad Version
"""
def isBadVersion(self, n: int) -> bool:
    return True

class Solution:
    def firstBadVersion(self, n: int) -> int:
        left = 1
        right = n
        
        while left <= right:
            mid = left + (right - left) // 2
            if isBadVersion(mid):
                right = mid - 1
            else:
                left = mid + 1
            
        return left

    def firstBadVersion_solution(self, n: int) -> int:
        left = 1
        right = n
        
        while left < right:
            mid = left + ((right - left) >> 1)
            if isBadVersion(mid):
                right = mid
            else:
                left = mid + 1
            
        return left