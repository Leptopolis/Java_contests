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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int val = l1.val + l2.val;
        int y = 0;
        if(val >= 10){
            val -= 10;
            y = 1;
        }
        ListNode t = new ListNode(val);
        if(l1.next != null && l2.next == null){
            l2.next = new ListNode(0);
        }
        if(l1.next == null && l2.next != null){
            l1.next = new ListNode(0);
        }
        if(l1.next == null && y == 1){
            t.next = new ListNode(1);
            return t;
        }
        if(l1.next == null){
            return t;
        }
        l1.next.val += y;

        
        t.next = addTwoNumbers(l1.next, l2.next);
        return t;
    }
}