/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    	public void recFun(int start,int end,ListNode[] result,ListNode root,int length,boolean flag){
		if(start == end)
			return;
		double factor = (double)length/(end - start);
		int count = 0;
		if(flag == false)
			count = (int)Math.ceil(factor);
		else 
			count = (int)Math.floor(factor);
		ListNode prev = null;
		ListNode current = root;
		int i = count;
		while(current != null && i-- > 0){
			prev = current;
			current = current.next;
		}
		if(prev != null)
			prev.next = null;
		result[start] = root;
		if(flag == false && Math.ceil(factor) == Math.floor(factor))
			flag = true;
		recFun(start + 1,end,result,current,length - count,flag );
	}
	
	public int getLength(ListNode root){
		int length = 0;
		ListNode current = root;
		while(current != null){
			length++;
			current = current.next;
		}
		return length;
	}
    
    public ListNode[] splitListToParts(ListNode root, int k) {
    	ListNode[] result = new ListNode[k];
    	int length = getLength(root);
    	boolean flag = false;
    	recFun(0,k,result,root,length,flag);
    	return result;
    }
}
