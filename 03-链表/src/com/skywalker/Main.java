package com.skywalker;

import com.skywalker.circle.CircleLinkedList;
import com.skywalker.circle.SingleCircleLinkedList;
import com.skywalker.single.SingleLinkedList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> list2 = new SingleLinkedList<Integer>();
		
		for (int i = 0; i < 10; i++) {
			list2.add(i);
		}
		list2.remove(1);
		System.out.println("单向链表"+"\n"+list2+"\n");
		
		List<Integer> list = new LinkedList<Integer>();
		
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		list.remove(1);
		System.out.println("双向链表"+"\n"+list+"\n");
		
		
		List<Integer> list3 = new SingleCircleLinkedList<Integer>();
		
		for (int i = 0; i < 10; i++) {
			list3.add(i);
		}
		for (int i = 0; i < 5; i++) {
			list3.remove(0);
		}
		list3.remove(1);
		System.out.println("单向循环链表"+"\n"+list3+"\n");
		
		List<Integer> list4 = new CircleLinkedList<Integer>();
		
		for (int i = 0; i < 10; i++) {
			list4.add(i);
		}
		list4.remove(8);
		System.out.println("双向循环链表"+"\n"+list4+"\n");
		
		
		/** 约瑟夫问题*/
		CircleLinkedList<Integer> list5 = new CircleLinkedList<>();
		for (int i = 1; i <= 8; i++) {
			list5.add(i);
		}
		
		list5.reset();
		
		System.out.println("约瑟夫问题");
		while (!list5.isEmpty()) {
			list5.next();
			list5.next();
			
			System.out.print(list5.remove()); 
		}
	}
}
