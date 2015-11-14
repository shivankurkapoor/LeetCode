package com.interview.array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Leet_Median {
	public static void main(String...args){
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        System.out.println(mf.findMedian());
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(22);
        System.out.println(mf.findMedian());
        mf.addNum(0);
        System.out.println(mf.findMedian());
	}
}

class MaxHeapComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return o2-o1;
	}

}
class MedianFinder{
	PriorityQueue<Integer> minHeap;
	PriorityQueue<Integer> maxHeap;

	MedianFinder(){
		minHeap = new PriorityQueue<Integer>();
		maxHeap = new PriorityQueue<Integer>(new MaxHeapComparator());
	}
	public void addNum(int num) {
		if(minHeap.size()==0&&maxHeap.size()==0){
			maxHeap.add(num);
		}
		else if(minHeap.size()==0){
			if(maxHeap.peek()>num){
				int max = maxHeap.remove();
				maxHeap.add(num);
				minHeap.add(max);
			}
			else{
				minHeap.add(num);
			}
		}
		else if(maxHeap.size()==0){
			if(minHeap.peek()<num){
				int min = minHeap.remove();
				minHeap.add(num);
				maxHeap.add(min);
			}
			else{
				maxHeap.add(num);
			}
		}
		else{
			if(num<maxHeap.peek())
				maxHeap.add(num);
			else
				minHeap.add(num);
			if(Math.abs(maxHeap.size()-minHeap.size())>1){
				if(maxHeap.size()>minHeap.size()){
					int temp = maxHeap.remove();
					minHeap.add(temp);
				}
				else{
					int temp = minHeap.remove();
					maxHeap.add(temp);
				}
			}
		}
	}

	public double findMedian() {
           if(maxHeap.size()==minHeap.size())
        	   return (maxHeap.peek()+minHeap.peek())/2.0;
           else if(maxHeap.size()>minHeap.size())
        	   return maxHeap.peek();
           else
        	   return minHeap.peek();
	}
}