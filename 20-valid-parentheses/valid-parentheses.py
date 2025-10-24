class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        st=[]
        for i in range(len(s)):
            if s[i]=='(' or s[i]=='{' or s[i]=='[':
                st.append(s[i])
            else:
                if len(st)==0:
                    return False
                p=st.pop()
                if (s[i]==']'and p!='[') or (s[i]=='}' and p!='{') or (s[i]==')'and p!='('):
                    return False
        return len(st)==0 
        