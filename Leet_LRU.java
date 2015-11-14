package com.interview.array;

import java.util.HashMap;

class CacheNode{
	int value;
	int pagenum;
	CacheNode next;
	CacheNode prev;
	CacheNode(int val,int pagenum){
		this.value = val;
		this.pagenum = pagenum;
	}
}

class Cache{
	int capacity;
	CacheNode head;
	CacheNode tail;
	int size;
	Cache(int capacity){
		this.capacity = capacity;
		size = 0;
		head = null;
		tail = null;
	}
}

public class Leet_LRU {
	static int size;
	static Cache cache;
	static HashMap<Integer,CacheNode> reg;
	public static void main(String...args){
		int capacity =10;
		LRUCache(capacity);
//		set(1,20);
//		print(cache);
//		System.out.println(get(1));
//		print(cache);
//		set(12,17);
//		print(cache);
//		set(9,1);
//		print(cache);
//		set(6,19);
//		print(cache);
//		System.out.println(get(4));
//		print(cache);
//		set(5,18);
//		print(cache);
//		System.out.println(get(5));
//		print(cache);
//		System.out.println(get(5));
//		print(cache);
//		set(8,1);
//		print(cache);
//		set(11,7);
//		print(cache);
//		set(5,2);
//		print(cache);
//		set(9,28);
//		print(cache);
//		System.out.println(get(1));
//		print(cache);
		
		set(10,13);print(cache);
		set(3,17);print(cache);
		set(6,11);print(cache);
		set(10,5);print(cache);
		set(9,10);print(cache);
		get(13);print(cache);
		set(2,19);print(cache);
		get(2);print(cache);
		get(3);print(cache);
		set(5,25);print(cache);
		get(8);print(cache);
		set(9,22);print(cache);
		set(5,5);print(cache);
		set(1,30);print(cache);
		get(11);print(cache);
		set(9,12);print(cache);
		get(7);print(cache);
		get(5);print(cache);
		get(8);print(cache);
		get(9);print(cache);
		set(4,30);print(cache);
		set(9,3);print(cache);
		get(9);print(cache);
		get(10);print(cache);
		get(10);print(cache);
		set(6,14);print(cache);
		set(3,1);print(cache);
		get(3);print(cache);
		set(10,11);print(cache);
		get(8);print(cache);
		set(2,14);print(cache);
		get(1);print(cache);
		get(5);print(cache);get(4);print(cache);set(11,4);print(cache);set(12,24);print(cache);set(5,18);print(cache);get(13);print(cache);
		set(7,23);print(cache);get(8);print(cache);get(12);print(cache);set(3,27);print(cache);set(2,12);print(cache);get(5);print(cache);
		set(2,9);print(cache);set(13,4);print(cache);set(8,18);print(cache);set(1,7);print(cache);get(6);print(cache);
		set(9,29);print(cache);set(8,21);print(cache);get(5);print(cache);set(6,30);print(cache);set(1,12);print(cache);
		get(10);print(cache);set(4,15);print(cache);set(7,22);print(cache);set(11,26);print(cache);set(8,17);print(cache);set(9,29);print(cache);get(5);print(cache);set(3,4);print(cache);set(11,30);print(cache);
		get(12);print(cache);set(4,29);print(cache);get(3);print(cache);get(9);print(cache);get(6);print(cache);set(3,4);print(cache);get(1);print(cache);get(10);print(cache);set(3,29);print(cache);set(10,28);print(cache);set(1,20);print(cache);set(11,13);print(cache);get(3);print(cache);
		set(3,12);print(cache);set(3,8);print(cache);set(10,9);print(cache);set(3,26);print(cache);get(8);print(cache);get(7);print(cache);get(5);print(cache);set(13,17);print(cache);set(2,27);print(cache);set(11,15);print(cache);get(12);print(cache);set(9,19);print(cache);set(2,15);print(cache);
		set(3,16);print(cache);
		print(cache);
		System.out.println(get(1));
		print(cache);
		set(12,17);
		print(cache);
		set(9,1);
		print(cache);
		set(6,19);
		print(cache);
		get(4);
		print(cache);
		get(5);
		print(cache);
		get(5);
		print(cache);
		set(8,1);
		print(cache);
		set(11,7);set(5,2);
		set(9,28);
		print(cache);
		get(1);
		set(2,2);
		set(7,4);set(4,22);set(7,24);set(9,26);set(13,28);set(11,26);
//		System.out.println(get(100));
//		print(cache);
//		System.out.println(get(102));
//		print(cache);
//		System.out.println(get(101));
//		print(cache);
//		System.out.println(get(103));
//		print(cache);
//		set(110,23);
//		print(cache);
//		set(111,29);
//		print(cache);
//		set(112,333);
//		print(cache);
//		set(113,88);
//		print(cache);
//		set(116,90);
//		print(cache);
//		System.out.println(get(128));
//		print(cache);
//		System.out.println(get(113));
//		print(cache);


	}

	private static void print(Cache cache2) {
		// TODO Auto-generated method stub
		CacheNode itr = cache.head;
		while(itr!=null){
			System.out.print(itr.value+"("+itr.pagenum+")"+"->");
			itr=itr.next;
		}
		System.out.println();


	}

	private static void set(int key, int value) {
		// TODO Auto-generated method stub
		if(!reg.containsKey(key)){
			CacheNode node = new CacheNode(value,key);
			reg.put(key,node);		

			if(cache.head==null){
				cache.size++;
				cache.head = cache.tail =node;	
			}
			else if(cache.size<cache.capacity){
				addFront(node);
				cache.size++;

			}
			else if(cache.size==cache.capacity){
				CacheNode temp = cache.tail;
				remove(cache.tail);
				addFront(node);
				reg.remove(temp.pagenum);
				cache.size++;
			}
		}
		else{
			CacheNode node = reg.get(key);
			node.value = value;
			if(!isFront(node)){
			remove(node);
			addFront(node);
			cache.size++;
			}
		}


	}

	private static void addFront(CacheNode node) {
		// TODO Auto-generated method stub
		node.prev = null;
		if(!(cache.head==null))
			cache.head.prev = node;

		node.next = cache.head;
		cache.head = node;
		if(cache.tail==null)
			cache.tail=node;
	}

	private static boolean isFront(CacheNode node) {
		// TODO Auto-generated method stub
		if(cache.head == node)
			return true;
		return false;
	}

	private static void remove(CacheNode cacheNode) {
		// TODO Auto-generated method stub
		
		if(cacheNode.prev!=null)
			cacheNode.prev.next = cacheNode.next;
		if(!(cacheNode.next==null))
			cacheNode.next.prev = cacheNode.prev;

		if(cache.tail==cacheNode){
			cache.tail = cacheNode.prev;
		}
		if(cache.head==cacheNode){
			cache.head=null;
		}
		cache.size--;
	}

	private static int get(int key) {
		// TODO Auto-generated method stub
		if(reg.containsKey(key)){
			CacheNode node = reg.get(key);
			int val = node.value;
			if(!isFront(node)){
				remove(node);
				addFront(node);
				cache.size++;
			}
			return val;
		}
		else return -1;
	}

	private static void LRUCache(int capacity) {
		// TODO Auto-generated method stub
		cache = new Cache(capacity);
		reg = new HashMap<>();
	}

}
