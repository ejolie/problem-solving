from typing import List

"""
Day15. Longest Turbulent Subarray
"""
class Solution:
    def maxTurbulenceSize(self, arr: List[int]) -> int:
        if len(arr) == 1:
            return 1
        
        curr_size, max_size = 1, 1
        direction = 'even'
        
        if arr[1] - arr[0] != 0:
            diff = arr[1] - arr[0]
            direction = 'down' if diff < 0 else 'up'
            max_size = 2
            curr_size = 2
        
        for i in range(1, len(arr) - 1):
            diff = arr[i + 1] - arr[i]
            if diff < 0:
                if direction == 'down':
                    max_size = max(max_size, curr_size)
                    curr_size = 2
                else:
                    direction = 'down'
                    curr_size += 1
            elif diff > 0:
                if direction == 'up':
                    max_size = max(max_size, curr_size)
                    curr_size = 2
                else:
                    direction = 'up'
                    curr_size += 1
            else:
                direction = 'even'
                max_size = max(max_size, curr_size)
                curr_size = 1
        
        max_size = max(max_size, curr_size)

        return max_size

solution = Solution()
print(solution.maxTurbulenceSize([9,4,2,10,7,8,8,1,9]))
print(solution.maxTurbulenceSize([4,8,12,16]))
print(solution.maxTurbulenceSize([100]))
print(solution.maxTurbulenceSize([0,0,0,0]))
print(solution.maxTurbulenceSize([0,1,1,0,1,0,1,1,0,0]))
print(solution.maxTurbulenceSize([0,8,45,88,48,68,28,55,17,24]))
