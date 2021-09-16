from typing import List

"""
Day16. Spiral Matrix
"""
class Solution:
    dirs = [
        [0, 1],  # right
        [1, 0],  # down
        [0, -1], # left
        [-1, 0], # up
    ]

    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:        
        n, m = len(matrix), len(matrix[0])
        visited = [[False for _ in range(m)] for __ in range(n)]
        result = [0 for _ in range(n * m)]
    
        dir_idx = 0
        i = 0
        cx, cy = 0, 0
        while i < n * m:
            visited[cx][cy] = True
            result[i] = matrix[cx][cy]
            
            nx = cx + self.dirs[dir_idx][0]
            ny = cy + self.dirs[dir_idx][1]
            
            if (nx < 0 or nx >= n) or (ny < 0 or ny >= m) or visited[nx][ny]:
                dir_idx = (dir_idx + 1) % 4
                cx += self.dirs[dir_idx][0]
                cy += self.dirs[dir_idx][1]
            else:
                cx = nx
                cy = ny
            
            i += 1
            
        return result

solution = Solution()
print(solution.spiralOrder([[1,2,3],[4,5,6],[7,8,9]]))
print(solution.spiralOrder([[1,2,3,4],[5,6,7,8],[9,10,11,12]]))
