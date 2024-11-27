package com.example.algorithm.kamaCoder.codeTop;

public class DeleteDuplicates1 {
    public class ListNode {
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

      public ListNode deleteDuplicates(ListNode head) {
          if (head ==null) {
                return head;
          }

          ListNode dummy = new ListNode(0, head);
          ListNode cur = dummy;
          while (cur.next != null && cur.next.next != null) {
                if (cur.next.val == cur.next.next.val) {
                      int x = cur.next.val;//注意要保存x，因为后面可能会有和x相同的节点
                      while (cur.next != null && cur.next.val == x) {
                          cur.next = cur.next.next;
                      }
                } else {
                    cur = cur.next;
                }
          }
          return dummy.next;
      }

}
