package uo.mp2223.util.collections.impl;

import uo.mp.lab.util.check.ArgumentChecks;
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
	public void clear() {
		
		head = null;
		numberOfElements = 0;

	}

	@Override
	public Object get(int index) {
		
		return getNode(index).value;
		
	}

	@Override
	public Object set(int index, Object element) {
		
		Node n = getNode(index);
		Object value = n.value;
		n.value = element;
		return value;
		
	}

	@Override
	public void add(int index, Object element) {
		
		ArgumentChecks.isTrue(index >= 0 && index < size());
		
		if(size() == 0) {
			
			addFirst(element);
			
		}else {
			
			Node prev = getNode(index-1);
			prev.next = new Node(element, prev.next);
			numberOfElements++;
			
		}

	}

	@Override
	public Object remove(int index) {
		
		Object value = null;
		
		if(index==0) {
			
			value = head.value;
			head = head.next;
			
		} else {
			
			Node prev = getNode(index-1);
			value = head.value;
			prev.next = null;
			
		}
		
		numberOfElements--;
		return value;
		
	}

	@Override
	public int indexOf(Object o) {
		
		Node node = head;
		
		for(int i=0; i<size(); i++) {
			if(node.value.equals(o)) {
				return i;
			}
		}
		
		return -1;
		
	}
	
	private Node getNode(int pos) {
		
		Node node = head;
		
		int count = 0;
		
		while(count != pos) {
			
			node = node.next;
			count++;
			
		}
		
		return node;
		
	}
	
	private void addFirst(Object o) {
		
		ArgumentChecks.isTrue(o != null);
		head = new Node(o, head);
		numberOfElements++;
		
	}

}
