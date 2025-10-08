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
    public ListNode mergeKLists(ListNode[] lists) {
       List<Integer> l=new ArrayList<>();
       for(var s: lists){
        ListNode head=s;
        while(head!=null){
            l.add(head.val);
            head=head.next;
        }
       }
       Collections.sort(l);
       ListNode head=new ListNode(-1);
       ListNode temp=head;
       for(var s:l){
        temp.next=new ListNode(s);
        temp=temp.next;
       }
return head.next;
    }
}