class LRUCache {
HashMap<Integer,Node>mp;
link obj;
int size;
int ca;
    public LRUCache(int capacity) {
       mp=new HashMap<>();
       obj=new link();
       size=0;
       ca=capacity;

    }
    
    public int get(int key) {
        if(!mp.containsKey(key)){
return -1;
        }
        Node x=mp.get(key);
        obj.movefront(x);
        return x.val;

    }
    
    public void put(int key, int val) {
        if(mp.containsKey(key)){
            Node x = mp.get(key); // get existing node
    x.val = val;          
            mp.put(key,x);
            obj.movefront(x);
            return;
        }
        if(size==ca){
            Node x=obj.delete();
            mp.remove(x.key);
            size--;
        }
        Node x=new Node(key,val);
        obj.insert(x);
        mp.put(key,x);
        size++;

    }
}
class Node{
    Node next;
    Node prev;
    int key;
    int val;
    Node(){

    }
    Node(int key,int val){
        this.key=key;
        this.val=val;
    }
}
class link{
    Node head,tail;
    link(){
        head=new Node();
        tail=new Node();
        head.next=tail;
        tail.prev=head;
    }
    public void insert(Node x){
        x.next=head.next;
        head.next.prev=x;
    head.next=x;
    x.prev=head;
    }
    public void movefront(Node x){
        x.prev.next=x.next;
        x.next.prev=x.prev;
        insert(x);
    }
    public Node delete(){
        Node x=tail.prev;
        x.prev.next=tail;
        tail.prev=x.prev;
        return x;

    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */