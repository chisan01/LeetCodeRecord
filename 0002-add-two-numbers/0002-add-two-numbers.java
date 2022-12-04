class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = l1.val + l2.val;
        ListNode root = new ListNode(sum % 10, null);
        int sumOfTen = sum / 10;
        l1 = l1.next;
        l2 = l2.next;

        ListNode prev = root;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + sumOfTen;
            ListNode cur = new ListNode(sum % 10, null);
            sumOfTen = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            prev.next = cur;
            prev = cur;
        }

        while(l1 != null) {
            sum = l1.val + sumOfTen;
            ListNode cur = new ListNode(sum % 10, null);
            sumOfTen = sum / 10;
            l1 = l1.next;
            prev.next = cur;
            prev = cur;
        }

        while(l2 != null) {
            sum = l2.val + sumOfTen;
            ListNode cur = new ListNode(sum % 10, null);
            sumOfTen = sum / 10;
            l2 = l2.next;
            prev.next = cur;
            prev = cur;
        }

        if(sumOfTen != 0) {
            prev.next = new ListNode(sumOfTen, null);
        }

        return root;
    }
}