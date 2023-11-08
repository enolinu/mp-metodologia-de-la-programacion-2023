package uo.mp2223.newsstand.service.sort;

import java.util.Comparator;

import uo.mp2223.newsstand.domain.Order;



public class ByNameAndQuantityOrdersComarator implements Comparator<Order> {

	@Override
	public int compare(Order o1, Order o2) {
		if(o1.getName().compareTo(o2.getName()) == 0) {
			return o1.getQuantity() - o2.getQuantity();
		} else {
			return o1.getName().compareTo(o2.getName());
		}	
	}
	
}
