package com.skywalker.list;


public class LinkedList<E> extends AbstractList<E> {
	
	private Node<E> first;
	private Node<E> last;
	
	private static class Node <E>{
		E element;
		Node<E> prev;
		Node<E> next;
		
		public Node(Node<E> prev,E element, Node<E> next) {
			super();
			this.prev = prev;
			this.element = element;
			this.next = next;
		}
		
		@Override
		public String toString() {
			StringBuilder strb = new StringBuilder();
			if(prev == null) {
				strb.append("null");
			}else {
				strb.append(prev.element);
			}
			strb.append("_" + element + "_");
			if(next == null) {
				strb.append("null");
			}else {
				strb.append(next.element);
			}
			return strb.toString();
		}
	}

	public void clear() {
		size = 0;
		first = null;
		last = null;
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
		
		if(index == size) {
			
			Node<E> oldLast = last;
			
			last = new Node<>(oldLast, element, null);
			
			if(oldLast == null) {
				first = last; // size == 0 的时候
			}else {
				oldLast.next = last;
			}
			
		}else {
			Node<E> next = node(index);
			Node<E> prev = next.prev;
			Node<E> node = new Node<>(prev, element, next);
			next.prev = node;
			
			if(prev == null) {
				first = node;
			}else {
				prev.next = node;
			}
		}
		size++;
	}

	public E remove(int index) {
		rangeCheck(index);
		
		Node<E> node = node(index);
		Node<E> prev = node.prev;
		Node<E> next = node.next;
		
		if(prev == null) { // index = 0
			first = next;
		}else {
			prev.next = next;
		}
		
		if(next == null) { // index = size - 1
			last = prev;
		}else {
			next.prev = prev;
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
		
		if(index<(size>>1)) {
			Node<E> node = first;
			for (int i = 0; i < index ; i++) {
				node = node.next;
			}
			return node;
		}else {
			Node<E> node = last;
			for (int i = size-1; i > index ; i++) {
				node = node.prev;
			}
			return node;
		}
		
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
