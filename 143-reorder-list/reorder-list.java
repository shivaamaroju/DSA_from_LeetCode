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
    public ListNode midd(ListNode head){
        // if(head==null)retrun null;
        ListNode s=head,f=head;
        while(f!=null&&f.next!=null){
        s=s.next;
        f=f.next.next;
        }
        return s;
    }
    public ListNode rev(ListNode head){
        ListNode prev=null,cur=head,next=null;
        while(cur!=null){
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }
    public ListNode fun(ListNode head1,ListNode head2){
        if(head1==null&&head2==null)return null;
        if(head1==null)return head2;
        if(head2==null)return head1;
        head1.next =fun(head2,head1.next);
        return head1;
    }
}