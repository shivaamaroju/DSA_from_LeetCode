class Solution(object):
    def maxSubArray(self, n):
        """
        :type nums: List[int]
        :rtype: int
        """
        m=c=n[0]
        for x in n[1:]:
            c=max(x,c+x)
            m=max(m,c)
        return m

        