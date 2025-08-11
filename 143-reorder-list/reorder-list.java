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
    public void reorderList(ListNode head) {
        ListNode mid=midd(head);
        ListNode x=rev(mid.next);
        mid.next=null;
        head=fun(head,x);
    }
    public static ListNode fun(ListNode h1,ListNode h2){
        if(h1==null&&h2==null)return null;
        if(h1==null)return h2;
        if(h2==null)return h1;
        h1.next=fun(h2,h1.next);
        return h1;
    }
    public static ListNode midd(ListNode head){
        ListNode s=head,f=head;
        while(f!=null&&f.next!=null){
            s=s.next;
            f=f.next.next;
        }
        return s;
    }
    public static ListNode rev(ListNode head){
        ListNode p=null,c=head,n=null;
        while(c!=null){
            n=c.next;
            c.next=p;
            p=c;
            c=n;
        }
        return p;
    }
}