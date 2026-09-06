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
        ArrayList<ListNode> list = new ArrayList<>();
        for(ListNode node:lists){
            while(node != null){
                list.add(node);
                node = node.next;
            }
        }
      // Arrays.sort(list,(a,b)->Integer.compare(a.val-b.val));
        Collections.sort(list,(a,b)->(a.val-b.val));
        ListNode head = new ListNode(0);
       // Node head = new Node(0);
       // head.next = list.get(0);
       ListNode tail = head;
        for(int i = 0;i<list.size();i++){
            ListNode node = list.get(i);
            tail.next = node;
            node.next = null;
            tail = tail.next;
        }
        return head.next;
        // void addToTail(Node node){

        // }
    }
}