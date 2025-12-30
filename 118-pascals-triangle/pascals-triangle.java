class Solution {
    public List<List<Integer>> generate(int n) {
         int a[][]=new int[n][];
	    for(int i=0;i<n;i++){
	        a[i]=new int[i+1];
	    }
            List<List<Integer>> ll=new ArrayList<>();
	    for(int i=0;i<n;i++){
	        for(int j=0;j<a[i].length;j++){
	            if(j==0||j==a[i].length-1)a[i][j]=1;
	            else{
	                
	                a[i][j]=a[i-1][j-1]+a[i-1][j];
	            }
		
	        }
	    }
        for(int i=0;i<a.length;i++){
    List<Integer> l=new ArrayList<>();
    for(int j=0;j<a[i].length;j++){
        l.add(a[i][j]);
    }
    ll.add(l);
}     
return ll;
    }
}