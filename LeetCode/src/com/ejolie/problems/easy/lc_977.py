from typing import List
from collections import deque

"""
977. Squares of a Sorted Array
"""
class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        result = [num**2 for num in nums]
        result.sort()
        return result

    def sortedSquares_twoPointer(self, nums: List[int]) -> List[int]:
        result = [0] * len(nums)
        left = 0
        right = len(nums) - 1
        
        for i in range(len(nums) - 1, -1, -1):
            if abs(nums[left]) > abs(nums[right]):
                result[i] = nums[left]**2
                left += 1
            else:
                result[i] = nums[right]**2
                right -= 1
        
        return result

    def sortedSquares_twoPointer_deque(self, nums: List[int]) -> List[int]:
        result = deque()
        left = 0
        right = len(nums) - 1
        
        while left <= right:
            if abs(nums[left]) > abs(nums[right]):
                result.appendleft(nums[left]**2)
                left += 1
            else:
                result.appendleft(nums[right]**2)
                right -= 1
        
        return list(result)