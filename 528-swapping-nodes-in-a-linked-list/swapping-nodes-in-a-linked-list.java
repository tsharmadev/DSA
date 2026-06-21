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
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null) return null;
        
        // Step 1: Find length of linked list
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        
        // Step 2: Find kth node from beginning
        ListNode first = head;
        for (int i = 1; i < k; i++) {
            first = first.next;
        }
        
        // Step 3: Find kth node from end (length - k + 1 from beginning)
        ListNode second = head;
        for (int i = 1; i < length - k + 1; i++) {
            second = second.next;
        }
        
        // Step 4: Swap values
        int tempVal = first.val;
        first.val = second.val;
        second.val = tempVal;
        
        return head;
    }
}