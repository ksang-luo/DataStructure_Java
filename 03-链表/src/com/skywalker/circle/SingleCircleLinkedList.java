package com.skywalker.circle;


import com.skywalker.AbstractList;


public class SingleCircleLinkedList<E> extends AbstractList<E> {
	
	private Node<E> first;
	
	private static class Node <E>{
		E element;
		Node<E> next;
		public Node(E element, Node<E> next) {
			super();
			this.element = element;
			this.next = next;
		}
		
		@Override
		public String toString() {
			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append(element + "_");
			if(next == null) {
				sBuilder.append("null");
			}else {
				sBuilder.append(next.element);
			}
			return sBuilder.toString();
		}
	}

	public void clear() {
		size = 0;
		first = null;
	}
	public E get(int index) {
		return node(index).element;
	}

	public E set(int index, E element) {
		Node<E> node = node(index);
		E old = node.element;
		node.element = element;
		return old;
	}

	public void add(int index, E element) {
		rangeCheckForAdd(index);
		
		if(index == 0) {
			
			Node<E> newFirst = new Node<>(element, first);
			Node<E> last = size == 0 ? newFirst : node(size - 1);
			last.next = newFirst;
			first = newFirst;
		}else {
			Node<E> prev = node(index - 1);
			prev.next = new Node<>(element, prev.next);
		}
		size++;
	}

	public E remove(int index) {
		rangeCheck(index);
		
		Node<E> node = first;
		if(index == 0) {
			
			if(size == 1) {
				first = null;
			}else {
				
				Node<E> last = node(size - 1);
				first = first.next;
				last.next = first;
				
			}
			
		}else {
			Node<E> prev = node(index-1);
			node = prev.next;
			prev.next = node.next;
		}
		size--;
		return node.element;
	}

	public int indexOf(E element) {
		
		if(element == null) {
			
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				if (node.element == null) return i;
				node = node.next;
			}
		}else {
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				if(element.equals(node.element)) return i;
				node = node.next;
			}
		}
		return ELEMENT_NOTFOUND;
	}
	
	private Node<E> node(int index) {
		rangeCheck(index);
		
		Node<E> node = first;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
		
	}
	
	@Override
	public String toString() {
		// size = 3 , [11,22,33]
		StringBuilder strb = new StringBuilder();
		strb.append("size = ").append(size).append(" , [");
		Node<E> node = first;
		for (int i = 0; i < size; i++) {
			if(i!=0) {
				strb.append(",");
			}
			strb.append(node);
			node = node.next;
		}
		strb.append("]");
		return strb.toString();
	}
	
}
