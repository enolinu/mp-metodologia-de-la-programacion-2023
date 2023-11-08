package uo.mp2223.util.collections.impl;

import uo.mp2223.util.collections.List;

public class LinkedList extends AbstractList implements List {
	
	class Node {
		
		Object value;
		Node next;
		
		Node(Object value, Node next) {
			this.value = value;
			this.next = next;
		}
		
	}
	
	private Node head;

	@Override
	public int size() {
		
		return numberOfElements;
		
	}

	@Override
	public boolean isEmpty() {
		
		return size() == 0;
		
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(Object element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object set(int index, Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
