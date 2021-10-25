from collections import deque, defaultdict
from typing import List, Optional

from com.ejolie.problems.structure.TreeNode import TreeNode

"""
102. Binary Tree Level Order Traversal
"""
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        
        d = defaultdict(list)
        queue = deque()
        queue.append((0, root))
        
        while queue:
            depth, node = queue.popleft()
            d[depth].append(node.val)
            
            if node.left:
                queue.append((depth + 1, node.left))
            if node.right:
                queue.append((depth + 1, node.right))
                
        return d.values()