class Solution {

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int left, int right) {

        if (left == right) {
            return lists[left];
        }

        int mid = left + (right - left) / 2;

        ListNode L1 = merge(lists, left, mid);

        ListNode L2 = merge(lists, mid + 1, right);

        return merge_answer(L1, L2);
    }

    public ListNode merge_answer(ListNode L1, ListNode L2) {

        if (L1 == null) {
            return L2;
        }

        if (L2 == null) {
            return L1;
        }

        if (L1.val <= L2.val) {

            L1.next = merge_answer(L1.next, L2);

            return L1;

        } else {

            L2.next = merge_answer(L1, L2.next);

            return L2;
        }
    }
}