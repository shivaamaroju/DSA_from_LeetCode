class Solution(object):
    def solve(self, b):
        """
        :type board: List[List[str]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        r,c=len(b),len(b[0])
        q=[]
        visited=[[0]* c for _ in range(r)]
        for i in range(r):
            for j in range(c):
                if i==0 or i==r-1 or j==0 or j==c-1:
                    if b[i][j]=='O':
                        visited[i][j]=1
                        q.append([i,j])
        di=[-1,0,1,0]
        dj=[0,1,0,-1]
        while len(q)>0:
            x=q.pop()
            i,j=x[0],x[1]
            for k in range(4):
                ni,nj=di[k]+i,dj[k]+j
                if ni>=0 and nj>=0 and ni<r and nj<c and visited[ni][nj]==0 and b[ni][nj]=='O':
                    q.append([ni,nj])
                    visited[ni][nj]=1
        for i in range(r):
            for j in range(c):
                if visited[i][j]==0:
                    b[i][j]='X'
                else:
                    b[i][j]='O'
        return b
