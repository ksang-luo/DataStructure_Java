package com.skywalker;

public abstract class AbstractList<E> implements List<E> {
	/**
	 * 实际存在元素的数量
	 */
	protected int size;
	
	
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}

	public boolean contains(E element) {
		return indexOf(element) != ELEMENT_NOTFOUND;
	}

	public void add(E element) {
		add(size, element);
	}
	
	protected void outOfBounds(int index){
		throw new IndexOutOfBoundsException("size = "+size+"index"+index);
	}
	
	protected void rangeCheck(int index){
		if(index<0 || index>=size) {
			outOfBounds(index);
		}
	}
	
	protected void rangeCheckForAdd(int index){
		if(index<0 || index>size) {
			outOfBounds(index);
		}
	}
}
