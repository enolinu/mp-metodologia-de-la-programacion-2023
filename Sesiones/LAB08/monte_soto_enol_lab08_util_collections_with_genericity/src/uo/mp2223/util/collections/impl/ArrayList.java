package uo.mp2223.util.collections.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

import uo.mp.lab.util.check.ArgumentChecks;

public class ArrayList<T> extends AbstractList<T> {
	
	private static final int INITIAL_CAPACITY = 20;
	
	@SuppressWarnings("unchecked")
	private T[] elements = (T[]) new Object[INITIAL_CAPACITY];

	
	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		
		elements = (T[]) new Object[INITIAL_CAPACITY];

	}

	@Override
	public T get(int index) {
		
		ArgumentChecks.isTrue(index >= 0 && index < size());
		return elements[index];
		
	}

	@Override
	public T set(int index, T element) {
		
		ArgumentChecks.isTrue(index >= 0 && index < size() && element != null);
		ArgumentChecks.isTrue(element != null);
		
		// Rescatamos el elemento que había antes.
		T old = elements[index];
		elements[index] = element;
		return old;
		
	}

	@Override
	public void add(int index, T element) {
		
		ensureCapacity();
		
		for(int i=size(); i>index; i++) {
			elements[i] = elements[i-1];
		}
		

	}

	@Override
	public T remove(int index) {
		
		ArgumentChecks.isTrue(index >= 0 && index < numberOfElements);

        T obj = elements[index];

        for(int i=index; i<size()-1; i++) {

            elements[i] = elements[i+1];

        }

        numberOfElements--;
        return obj;
		
	}
	
	private void ensureCapacity() {
		
		if(size() == elements.length) {
			
			@SuppressWarnings("unchecked")
			T[] newList = (T[]) new Object[size()*2];
			
			for(int i=0; i<size(); i++) {
				newList[i] = elements[i];
			}
			
			elements = newList;
			
		}
		
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

	@Override
	public Iterator<T> iterator() {
		
		return new ArrayListIterator();
		
	}
	
	private class ArrayListIterator implements Iterator<T> {
		
		private int nextIndex;
		private T lastReturned;
		
		private ArrayListIterator() {
			nextIndex = 0;
			lastReturned = null;
		}

		@Override
		public boolean hasNext() {
			return nextIndex < size();
		}
		
		/**
		 * Devuelve el siguiente objeto de la lista si lo hay, y se mueve a la siguiente posición.
		 * Si no lo hay, salta una excepción.
		 * @return Elemento (objeto) siguiente de la lista.
		 * @throws NoSuchElementException si no hay elementos para devolver.
		 */
		@Override
		public T next() {
			
			if(!hasNext()) {
				throw new NoSuchElementException("No hay mas elementos en la lista!");
			}
			
			
			lastReturned = get(nextIndex);
			nextIndex++;
			return lastReturned;
		}
		
	}
}
