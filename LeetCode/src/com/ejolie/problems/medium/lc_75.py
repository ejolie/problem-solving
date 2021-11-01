from typing import List

"""
75. Sort Colors
"""
class Solution:

    def sortColors_bubbleSort(self, nums: List[int]) -> None:
        """ time: O(n^2) / space: O(1) """
        n = len(nums)
        for i in range(n):
            for j in range(0, n-i-1):
                if nums[j] > nums[j+1]:
                    nums[j], nums[j+1] = nums[j+1], nums[j]
    
    def sortColors_countingSort(self, nums: List[int]) -> None:
        """ time: O(n) / space: O(1) -> O(k) (k = num of colors)"""
        c0 = c1 = c2 = 0
        for num in nums:
            if num == 0:
                c0 += 1
            elif num == 1:
                c1 += 1
            elif num == 2:
                c2 += 1
                
        for i in range(c0):
            nums[i] = 0
        for i in range(c1):
            nums[c0 + i] = 1
        for i in range(c2):
            nums[c0 + c1 + i] = 2

    def sortColors_twoPointer(self, nums: List[int]) -> None:
        """ time: O(n) / space: O(1) """
        left = 0
        right = len(nums) - 1
        i = 0

        while i <= right:
            if nums[i] == 0:
                nums[i], nums[left] = nums[left], nums[i]
                left += 1
                i += 1
            elif nums[i] == 2:
                nums[i], nums[right] = nums[right], nums[i]
                right -= 1
            else:
                i += 1

    def sortColors_quickSort(self, nums: List[int]) -> None:
        """ time: O(nlogn) / space: O(logn) -> recursive call """
        pass
