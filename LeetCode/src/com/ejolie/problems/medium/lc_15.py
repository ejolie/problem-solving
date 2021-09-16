from typing import List


"""
15. 3Sum
"""
class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:        
        nums.sort()
        
        n = len(nums)
        answer = []
        
        for i in range(n - 2):
            if nums[i] > 0:
                break
            if i > 0 and nums[i] == nums[i - 1]:
                continue

            left = i + 1
            right = n - 1
            
            while 0 < left < right:
                total = nums[i] + nums[left] + nums[right]

                if total < 0:
                    left += 1
                elif total > 0:
                    right -= 1
                else:
                    answer.append([nums[i], nums[left], nums[right]])
                   
                    while left < right and nums[left] == nums[left + 1]:
                        left += 1
                    while left < right and nums[right] == nums[right - 1]:
                        right -= 1
                   
                    left += 1
                    right -= 1
        
        return answer


solution = Solution()
print(solution.threeSum([-1, 0, 1, 2, -1, -4]))
print(solution.threeSum([-1, 0, 1, 0]))
