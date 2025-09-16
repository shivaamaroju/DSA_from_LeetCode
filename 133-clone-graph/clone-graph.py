"""
# Definition for a Node.
class Node(object):
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""
import copy
class Solution(object):
    def cloneGraph(self, node):
        nodee=copy.deepcopy(node)
        return nodee
        
        