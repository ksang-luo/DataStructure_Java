package com.skywalker;

@SuppressWarnings("unchecked")
public class ArrayList<E> {
	
	/**
	 * 实际存在元素的数量
	 */
	private int size;
	
	/**
	 * 所有的元素
	 */
	private E[] elements;
	
	/**
	 *  定义常量 减少魔鬼数字
	 */
	private static final int DEFAULT_CAPACITY = 10;
	private static final int ELEMENT_NOTFOUND = -1;
	
	
	public ArrayList(int capacity) {
		capacity = (capacity>DEFAULT_CAPACITY)?capacity:DEFAULT_CAPACITY;
		elements = (E[]) new Object[capacity];
	}
	
	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}
	
	private void outOfBounds(int index){
		throw new IndexOutOfBoundsException("size = "+size+"index"+index);
	}
	
	private void rangeCheck(int index){
		if(index<0 || index>=size) {
			outOfBounds(index);
		}
	}
	
	private void rangeCheckForAdd(int index){
		if(index<0 || index>size) {
			outOfBounds(index);
		}
	}
	
	/**
	 * 保证要有capacity的容量
	 * @param capacity
	 */
	private void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if (capacity <= oldCapacity) return;
		
		int newCapacity = oldCapacity + (oldCapacity >> 1);// 同java源码1.5 iOS可为1.6+
		E[] newElements = (E[])new Object[newCapacity];
		
		for (int i = 0; i < oldCapacity; i++) {
			newElements[i] = elements[i];
		}
		System.out.println(oldCapacity + "扩容为" + newCapacity);
		elements = newElements;
	}
	
	/**
	 * 清除所有元素
	 */
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}

	/**
	 * 元素的数量
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * 是否为空
	 * @return
	 */
	public boolean isEmpty() {
		 return size == 0;
	}

	/**
	 * 是否包含某个元素
	 * @param element
	 * @return
	 */
	public boolean contains(E element) {
		return (indexOf(element)) != ELEMENT_NOTFOUND;
	}

	/**
	 * 添加元素到尾部
	 * @param element
	 */
	public void add(E element) {
		add(size, element);
	}

	/**
	 * 获取index位置的元素
	 * @param index
	 * @return
	 */
	public E get(int index) {
		rangeCheck(index);
		return elements[index];
	}

	/**
	 * 设置index位置的元素
	 * @param index
	 * @param element
	 * @return 原来的元素ֵ
	 */
	public E set(int index, E element) {
		rangeCheck(index);
		
		E oldElement = elements[index];
		elements[index] = element;
		return oldElement;
	}

	/**
	 * 在index位置插入一个元素
	 * @param index
	 * @param element
	 */
	public void add(int index, E element) {
		rangeCheckForAdd(index);
		ensureCapacity(size+1);
		
		for (int i = size; i > index; i--) {
			elements[i] = elements[i-1];
		}
		elements[index] = element;
		size++;
	}

	/**
	 * 删除index位置的元素
	 * @param index
	 * @return
	 */
	public E remove(int index) {
		rangeCheck(index);
		
		E oldElement = elements[index];

		for (int i = index+1; i < size; i++) {
			elements[i-1] = elements[i];
		}
		elements[--size] = null;
		return oldElement;
	}
	
	public void remove (E element) {
		remove(indexOf(element));
	}

	/**
	 * 查看元素的索引
	 * @param element
	 * @return
	 */
	public int indexOf(E element) {
		
		if(element == null) {
			for (int i = 0; i < size; i++) {
				if (elements[i] == null) return i;
			}
		}else {
			for (int i = 0; i < size; i++) {
				if(element.equals(elements[i])) return i;
			}
		}
		return ELEMENT_NOTFOUND;
	}
	
	
	@Override
	public String toString() {
		// size = 3 , [11,22,33]
		StringBuilder strb = new StringBuilder();
		strb.append("size = ").append(size).append(" , [");
		for (int i = 0; i < size; i++) {
			if(i!=0) {
				strb.append(",");
			}
			strb.append(elements[i]);
		}
		strb.append("]");
		return strb.toString();
	}
}
