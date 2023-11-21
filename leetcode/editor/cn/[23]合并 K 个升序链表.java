//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
//
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2505 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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
        ListNode res = null;
        for (int i = 0;i < lists.length;i++ ){
            res = mergeTwo(res,lists[i]);
        }
        return res;
    }

    public static ListNode mergeTwo(ListNode l1,ListNode l2){
        ListNode head = new ListNode(-1);
        ListNode current = head;
        while (null != l1 || null != l2){
            if (null == l1){
                current.next = l2;
                break;
            }
            if (null == l2){
                current.next = l1;
                break;
            }
            int x1 = l1.val,x2 = l2.val;
            if (x1 >= x2){
                current.next = l2;
                l2 = l2.next;
            }else {
                current.next = l1;
                l1 = l1.next;
            }
            current = current.next;
        }
        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
