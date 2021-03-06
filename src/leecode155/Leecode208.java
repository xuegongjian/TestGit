package leecode155;

public class Leecode208 {

	public static class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA ==null || headB == null) return null;
		
		ListNode aFirstHead = headA;
		ListNode bFirstHead = headB;
		int aLen = 1;

		int bLen = 1;
		while(null != headA.next){
			headA = headA.next;
			aLen++;
		}
		while(null != headB.next){
			headB = headB.next;
			bLen++;
		}
		if(headA != headB) return null;
		
		if(aLen > bLen){
			int delta = aLen - bLen;
			while(delta > 0){
				aFirstHead = aFirstHead.next;
				delta = delta - 1;
			}
		} else if(bLen > aLen){
			int delta = bLen - aLen;
			while(delta > 0){
				bFirstHead = bFirstHead.next;
				delta = delta - 1;
			}
		}
		while(true){
			if(aFirstHead== bFirstHead){
				return aFirstHead;
			}
			aFirstHead = aFirstHead.next;
			bFirstHead = bFirstHead.next;
		}
	}
}
