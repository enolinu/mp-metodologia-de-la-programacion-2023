package uo.mp2223.util.collections.impl;

import uo.mp2223.util.collections.List;

public abstract class AbstractList implements List {

	protected int numberOfElements = 0;

	public AbstractList() {
		super();
	}

	@Override
	public int size() {
		
		return numberOfElements;
		
	}

	@Override
	public boolean isEmpty() {
		
		return numberOfElements == 0;
		
	}

	@Override
	public boolean contains(Object o) {
		
		return indexOf(0) != -1;
		
	}

	@Override
	public boolean add(Object element) {
		
		// Validar que element != null.
		add(size(), element);
		return true;
		
	}

	@Override
	public boolean remove(Object o) {
		
		int position = indexOf(o);
		
		if(position != -1) {
			remove(position);
			return true;
		}
		
		return false;
		
	}

}