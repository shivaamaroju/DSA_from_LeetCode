class Solution(object):
    def maxSubArray(self, n):
        """
        :type nums: List[int]
        :rtype: int
        """
        m,c=n[0],n[0]
        for i in range(1,len(n)):
            c=max(n[i],c+n[i])
            m=max(m,c)
        return m

        