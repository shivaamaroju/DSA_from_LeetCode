class MedianFinder {
PriorityQueue<Integer> max;
PriorityQueue<Integer> min;
    public MedianFinder() {
        max=new PriorityQueue<>((x,y)-> x-y);
        min=new PriorityQueue<>((x,y)->  y-x);
    }
    
    public void addNum(int num) {
        if(max.isEmpty()||max.peek()<num)max.add(num);
        else min.add(num);
        if(max.size()-1>min.size())min.add(max.remove());
        if(min.size()>max.size())max.add(min.remove());
    }
    
    public double findMedian() {
        if(max.size()==min.size())return (max.peek()+min.peek())/2.0;
        return max.peek();
        
    }
}

