package com.interview.array;

import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}

class PQNode{
	ListNode node;
	int val = Integer.MAX_VALUE;
	int list_num;
	PQNode(ListNode node,int val,int list_num){
		this.node = node;
		this.list_num = list_num;
		this.val = val;
	}
}
class PQComparator implements Comparator<PQNode>{

	@Override
	public int compare(PQNode n1, PQNode n2) {
		// TODO Auto-generated method stub
		if(n1.val<n2.val)
			return -1;
		else if(n1.val==n2.val)
			return 0;
		else
			return 1;
		//return (int) (n1.val-n2.val);
	}
	
}
public class Leet_Merge_K_Lists {
public static void main(String...args){
	ListNode []kLists = new ListNode[4];
    kLists[0] = null;
//    kLists[0].next = new ListNode(6);
//    kLists[0].next.next = new ListNode(7);
//    kLists[0].next.next.next = new ListNode(8);
//    
    kLists[1] = new ListNode(-1);
    kLists[1].next = new ListNode(5);
    kLists[1].next.next = new ListNode(11);
    //kLists[1].next.next.next = new ListNode(4);
   
    kLists[2] = null;
//    kLists[2].next = new ListNode(0);
//    kLists[2].next.next = new ListNode(11);
//    kLists[2].next.next.next = new ListNode(12);
	
    kLists[3] = new ListNode(6);
    kLists[3].next = new ListNode(10);
  //  kLists[3].next.next = new ListNode(11);
	
    ListNode finalList;
    finalList = mergeKLists(kLists);
    while(finalList!=null){
    	System.out.println(finalList.val);
    	finalList = finalList.next;
    }
}

private static ListNode mergeKLists(ListNode[] kLists) {
	// TODO Auto-generated method stub
	int size = kLists.length;
	 if(size==0)
	     return null;
	ListNode finalListHead=null;
	ListNode nextPtr = finalListHead;
	PriorityQueue<PQNode> pq = new PriorityQueue<>(size,new PQComparator());
	
	ListNode[] itr = new ListNode[size];
	
	for(int i=0;i<size;i++)
		{ 
		   itr[i] = kLists[i];
		   if(itr[i]!=null)
		   pq.add(new PQNode(itr[i],itr[i].val,i));
		   else
		   pq.add(new PQNode(null,Integer.MAX_VALUE,i));
		}
	
	while(true){
		PQNode n = pq.remove();
		ListNode l = n.node;
		int ln = n.list_num;
		if(l==null)
			break;
		ListNode temp = new ListNode(l.val);
		if(finalListHead==null){
			finalListHead = temp;
			nextPtr = finalListHead;
		}
		else{
			nextPtr.next = temp;
			nextPtr = nextPtr.next;
		}
		
		itr[ln] = itr[ln].next;
		if(!(itr[ln]==null))
		pq.add(new PQNode(itr[ln],itr[ln].val,ln));
		else
			pq.add(new PQNode(null,Integer.MAX_VALUE,ln));	
	}
	
	
	return finalListHead;
	
}
}
