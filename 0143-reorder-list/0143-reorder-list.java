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
        if(head == null || head.next == null) return;

        ListNode s = head;
        ListNode f = head;

        // find middle node

        while(f.next!=null && f.next.next!=null){
            s = s.next;
            f = f.next.next;
        }

        // separate the linked list into 2 linked list by one node less than middle

        ListNode second = s.next;

        s.next = null;

        // reverse the second list

        ListNode prev = null;
        ListNode curr = second;
        ListNode agla = null;

        while(curr != null){
            agla = curr.next;
            curr.next = prev;
            prev = curr;
            curr = agla;
        }

        // merge the first and reversed second list

        ListNode t1 = head;
        ListNode t2 = prev;

        while(t2 != null){
            ListNode temp1 = t1.next;
            ListNode temp2 = t2.next;

            t1.next = t2;
            t2.next = temp1;

            t1 = temp1;
            t2 = temp2;
        }
        

    }
}