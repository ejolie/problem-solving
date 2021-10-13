from typing import List

"""
36. Valid Sudoku
"""
class Solution:
    BLANK = '.'
    
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        for row in board:
            if not self._is_valid_row(row):
                return False
            
        for col in range(9):
            if not self._is_valid_column(col, board):
                return False
        
        for i in range(0, 9, 3):
            for j in range(0, 9, 3):
                if not self._is_valid_square(i, j, board):
                    return False
            
        return True
    
    def _is_valid_row(self, row: List[str]) -> bool:
        duplicated = [False] * 10
        
        for num in row:
            if num == self.BLANK:
                continue
            if duplicated[int(num)]:
                return False
            duplicated[int(num)] = True
            
        return True
    
    def _is_valid_column(self, col: int, board: List[List[str]]) -> bool:
        duplicated = [False] * 10

        for row in range(9):
            if board[row][col] == self.BLANK:
                continue
            if duplicated[int(board[row][col])]:
                return False
            duplicated[int(board[row][col])] = True
        
        return True
    
    def _is_valid_square(self, start_row: int, start_col: int, board: List[List[str]]) -> bool:
        duplicated = [False] * 10

        for i in range(start_row, start_row + 3):
            for j in range(start_col, start_col + 3):
                if board[i][j] == self.BLANK:
                    continue
                if duplicated[int(board[i][j])]:
                    return False
                duplicated[int(board[i][j])] = True
        
        return True