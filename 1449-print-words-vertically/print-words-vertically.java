class Solution {
    public List<String> printVertically(String s) {
        List<String>res = new ArrayList<>();
        int max = 0;
        for(var i : s.split(" "))
            max = Math.max(max,i.length());
        String ans = "";
        for(var i : s.split(" "))
                ans += i+"*".repeat(max-i.length());
        System.out.println(ans);
        ans = ans.trim();
        for(int i = 0 ; i < max ; i++){
            String str = "";
            int j = i;
            while(j  < ans.length()){
                char ch = ans.charAt(j);
                if(ch == '*')
                    str += " ";
                else str += ch;
                j += max;
            }
            res.add(str.stripTrailing());
        }

        
        return res;
    }
}