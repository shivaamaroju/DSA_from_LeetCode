class Solution(object):
    def totalMoney(self, n):
        """
        :type n: int
        :rtype: int
        """
        t=(n//7)*7+n%7
        res,x,y=0,1,1
        while t!=0:
            res+=x
            if y%7==0:
                x=x-6+1
                y=1
            else:
                x+=1
                y+=1
            t-=1
        return res