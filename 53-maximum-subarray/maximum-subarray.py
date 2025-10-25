class Solution(object):
    def maxSubArray(self, n):
        """
        :type nums: List[int]
        :rtype: int
        """
        m=c=n[0]
        for i in n[1:]:
            c=max(i,i+c)
            m=max(m,c)
        return m
        