class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        st=[]
        for ch in s:
            if ch in '[{(':
                st.append(ch)
            else:
                if len(st)==0:
                    return False
                p=st.pop()
                if (ch=='}'and p!='{')or(ch==']'and p!='[')or(ch==')'and p!='('):
                    return False
        return len(st)==0