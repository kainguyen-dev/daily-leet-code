package prepare;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


public class _1_MergeKSortedLists {
    // https://leetcode.com/problems/merge-k-sorted-lists/description/

    // Space O(1)
    // Time O(kN)
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int minIdx = 0;

        while (true) {
            boolean isBreak = true;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                // Still some node left
                if (lists[i] != null) {
                    if (lists[i].val < min) {
                        minIdx = i;
                        min = lists[i].val;
                    }
                    isBreak = false;
                }
            }
            if (isBreak) break;
            cur.next = lists[minIdx];
            cur = cur.next;
            lists[minIdx] = lists[minIdx].next;
        }
        return head.next;
    }

    public ListNode mergeKListsHeap(ListNode[] lists) {
        Comparator<ListNode> cmp = Comparator.comparingInt(o -> o.val);

        Queue<ListNode> q = new PriorityQueue<>(cmp);

        for (ListNode l : lists) {
            if (l != null) {
                q.add(l);
            }
        }

        ListNode head = new ListNode(0);
        ListNode cur = head;

        while (!q.isEmpty()) {
            cur.next = q.poll();
            cur = cur.next;
            ListNode next = cur.next;

            if (next != null) q.add(next);
        }
        return head.next;
    }

}
