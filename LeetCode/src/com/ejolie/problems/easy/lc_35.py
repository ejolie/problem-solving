from typing import List

"""
35. Search Insert Position

cf. https://leetcode.com/problems/search-insert-position/discuss/249092/Come-on-forget-the-binary-search-patterntemplate!-Try-understand-it!

1. if nums[mid] < target, we can insert target into `mid + 1`,
   so the minimum possible index is `mid + 1`.
2. if nums[mid] > target, we can insert target into `mid`,
   so `mid` can be the potential candidate.
"""
class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums)
        
        while left < right:
            mid = left + ((right - left) >> 1)
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid
        
        return left

solution = Solution()
assert solution.searchInsert([1,3], 2) == 1
assert solution.searchInsert([1,3,5,6], 2) == 1
assert solution.searchInsert([1,3,5,6], 7) == 4
assert solution.searchInsert([1,3,5,6], 0) == 0