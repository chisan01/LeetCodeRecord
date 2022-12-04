class Solution {

    private void concat(ListNode prev, ListNode other, int carry) {
        while (other != null) {
            int sum = other.val + carry;
            ListNode cur = new ListNode(sum % 10, null);
            carry = sum / 10;
            other = other.next;
            prev.next = cur;
            prev = cur;
        }
        if(carry != 0) {
            prev.next = new ListNode(carry, null);
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = l1.val + l2.val;
        ListNode root = new ListNode(sum % 10, null);
        int carry = sum / 10;
        l1 = l1.next;
        l2 = l2.next;

        ListNode prev = root;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            ListNode cur = new ListNode(sum % 10, null);
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            prev.next = cur;
            prev = cur;
        }

        if(l1 == null && l2 == null && carry != 0) {
            prev.next = new ListNode(carry, null);
        }
        else if(l1 != null) {
            concat(prev, l1, carry);
        }
        else {
            concat(prev, l2, carry);
        }
        return root;
    }
}