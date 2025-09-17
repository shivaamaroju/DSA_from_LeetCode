/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode c=list1;
        ListNode d=list2;
        ListNode y=new ListNode(-1);
        ListNode temp=y;
        while(c!=null&&d!=null){
            if(c.val<d.val){
                temp.next=new ListNode(c.val);
                
                c=c.next;
            }
            else{
                  temp.next=new ListNode(d.val);
                d=d.next;
            }
            temp=temp.next;
        }
        
while(c!=null){
    temp.next=new ListNode(c.val);
    temp=temp.next;
    c=c.next;
}
while(d!=null){
    temp.next=new ListNode(d.val);
    temp=temp.next;
    d=d.next;
}
return y.next;
    }
}