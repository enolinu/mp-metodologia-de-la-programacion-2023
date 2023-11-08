package uo.mp2223.util.collections.impl;

import uo.mp.lab.util.check.ArgumentChecks;

public class ArrayList extends AbstractList {
	
	private static final int INITIAL_CAPACITY = 20;
	
	private Object[] elements = new Object[INITIAL_CAPACITY];
	
	@Override
	public void clear() {
		
		for(int i=0; i<size(); i++) {

            elements[i] = null;
        
        }

	}

	@Override
	public Object get(int index) {
		
		ArgumentChecks.isTrue(index >= 0 && index < size());
		return elements[index];
		
	}

	@Override
	public Object set(int index, Object element) {
		
		ArgumentChecks.isTrue(index >= 0 && index < size() && element != null);
		
		// Rescatamos el elemento que había antes.
		Object old = elements[index];
		elements[index] = element;
		return old;
		
	}

	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object remove(int index) {
		
		ArgumentChecks.isTrue(index >= 0 && index < numberOfElements);

        Object obj = elements[index];

        for(int i=index; i<size()-1; i++) {

            elements[i] = elements[i+1];

        }

        numberOfElements--;
        return obj;
		
	}

	@Override
	public int indexOf(Object o) {
		
		for(int i=0; i<size(); i++) {
			
			if(elements[i].equals(o)) {
				return i;
			}
			
		}
		
		return -1;
	}

}
