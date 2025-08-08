class MedianFinder {
PriorityQueue<Integer> max;
PriorityQueue<Integer> min;

    public MedianFinder() {
        max=new PriorityQueue<>((x,y)->{
            return y-x;
        });
       min =new PriorityQueue<>((x,y)->{
            return x-y;
        });
    }
    
    public void addNum(int num) {
        if(max.isEmpty()||(num<=max.peek()))max.add(num);
        else min.add(num);
        if(max.size()>min.size()+1)min.add(max.remove());
        else if(min.size()>max.size()) {
            max.add(min.remove());
        }

        
    }
    
    public double findMedian() {
      if(max.size()==min.size())return (max.peek()+min.peek())/2.0;
      else return max.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */