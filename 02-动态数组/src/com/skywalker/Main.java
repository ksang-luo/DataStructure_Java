package com.skywalker;

public class Main {

	public static void main(String[] args) {
		
		/**
		 * 创建一个自己的动态数组 
		 */
		ArrayList<Object> list = new ArrayList<>();
		list.add(00);
		list.add(11);
		Person p1 = new Person("jack", 11);
		list.add(p1);
		list.add(22);
		list.add("aaaa");
		list.add(44);
		list.add(55);
		list.add(66);
		list.add(77);
		list.add(88);
		list.add(99);
		list.remove(list.size()-1);
		
		Assert.test(list.size()==10);
		
		System.out.println(list);
		System.out.println(list.contains(11));
	}
}
