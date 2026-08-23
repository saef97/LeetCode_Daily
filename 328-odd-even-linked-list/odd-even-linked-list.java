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
    void insertAtEnd(int node, ListNode head) {
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        ListNode nnode = new ListNode(node);
        temp.next = nnode;
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;
        int n = 0;
        //int count = 0;
        ListNode count = head;
        while (count != null) {
            n++;
            count = count.next;
        }

        int index = 1;
        ListNode temp = head;
        while (temp != null && index <= n) {
            if (index % 2 == 0 ) {
                insertAtEnd(temp.val, head);
            }
            index++;
            temp = temp.next;
        }
        int j = 1;
        ListNode temp2 = head;
        ListNode prev = null;
        while (j <= n && temp2 != null) {
            if (j % 2 == 0) {

                ListNode curr = temp2;
                prev.next = temp2.next;
                temp2 = temp2.next;
                curr.next = null;
                // temp2.next = null;
            } else {

                prev = temp2;
                // if(temp2.next == null)break;
                temp2 = temp2.next;
            }
            j++;
        }

        return head;

    }
}