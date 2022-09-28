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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        Stack<ListNode> S = new Stack<>();
        ListNode cur = head;
        while(cur != null) {
            S.add(cur);
            cur = cur.next;
        }
        
        ListNode del = S.peek();
        for(int i=0; i<n; i++) {
            del = S.pop();
        }
        
        if(S.isEmpty()) head = del.next;
        else S.pop().next = del.next;
        
        return head;
    }
}