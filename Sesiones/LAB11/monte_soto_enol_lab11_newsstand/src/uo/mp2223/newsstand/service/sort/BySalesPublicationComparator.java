package uo.mp2223.newsstand.service.sort;

import java.util.Comparator;

import uo.mp2223.newsstand.domain.Publication;

public class BySalesPublicationComparator implements Comparator<Publication> {

	// IMPORTANTE: Cambiar Object por Publication.
	
	@Override
	public int compare(Publication p1, Publication p2) {
		
		/*
		 0 si son iguales.
		 > 0 Si p1 > p2;
		 < 0 Si p1 < p2;
		 */
		
		return p1.getSales() - p2.getSales();
		// return (Double)p1.getSales.compareTo(p2)
		
	}

}
