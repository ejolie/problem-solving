from typing import List

"""
Day31. Find Minimum in Rotated Sorted Array
"""
class Solution:
    def findMin(self, nums: List[int]) -> int:
        left = 0
        right = len(nums) - 1

        while left < right:
            mid = (left + right) // 2
            if nums[mid] > nums[right]:
                left = mid + 1
            elif nums[mid] < nums[right]:
                right = mid

        return nums[left]
    
    def findMin_bruteForce(self, nums: List[int]) -> int:
        minNum = nums[0]
        
        for i in range(0, len(nums) - 1):
            if nums[i] > nums[i + 1]:
                minNum = nums[i + 1]
                break
                
        return minNum


solution = Solution()
assert solution.findMin([3, 4, 5, 1, 2]) == 1
assert solution.findMin([4, 5, 1, 2, 3]) == 1
assert solution.findMin([5, 1, 2, 3, 4]) == 1
assert solution.findMin([1, 2, 3, 4, 5]) == 1
