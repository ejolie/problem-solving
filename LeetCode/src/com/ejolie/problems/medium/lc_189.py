from typing import List

"""
189. Rotate Array
"""
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        k = k % n
        
        left = nums[:n-k]
        right = nums[n-k:]
        
        for i in range(k):
            nums[i] = right[i]   
        for i in range(n-k):
            nums[k+i] = left[i]

    def rotate_reverse(self, nums: List[int], k: int) -> None:
        """
        a = [1,2,3,4,5,6,7]
        k = 3

        1. reverse the whole array by swapping first element with the last one and so on..
        -> [7,6,5,4,3,2,1]

        2. reverse the elements from 0 to k-1
        reverse the elements 7,6,5
        -> [5,6,7,4,3,2,1]

        3. reverse the elements from k to n-1
        reverse the elements 4,3,2,1
        -> [5,6,7,1,2,3,4]
        """
        def reverse(left, right):
            while left < right:
                nums[left], nums[right] = nums[right], nums[left]
                left += 1
                right -= 1

        n = len(nums)
        k = k % n
        if k:
            reverse(0, n-1)
            reverse(0, k-1)
            reverse(k, n-1)
    
    def rotate_slice(self, nums: List[int], k: int) -> None:
        n = len(nums)
        k = k % n
        nums[:] = nums[n-k:] + nums[:n-k]

    def rotate_pop(self, nums: List[int], k: int) -> None:
        for _ in range(k):
            nums.insert(0, nums.pop())

    def rotate_timeLimitException(self, nums: List[int], k: int) -> None:
        for _ in range(k):
            prev = nums[0]
            for i in range(1, len(nums)):
                temp = nums[i]
                nums[i % len(nums)] = prev
                prev = temp
            nums[0] = prev
