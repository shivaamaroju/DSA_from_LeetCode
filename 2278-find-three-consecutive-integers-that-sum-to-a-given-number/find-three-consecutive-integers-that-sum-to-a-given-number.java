class Solution {
    public long[] sumOfThree(long num) {
long ans=(num-3)/3;
long ans2=ans*3+3;
if(ans2==num)return new long[]{ans,ans+1,ans+2};
return new long[]{};

        }
    }
