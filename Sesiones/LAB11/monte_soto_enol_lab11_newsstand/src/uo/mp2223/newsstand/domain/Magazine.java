package uo.mp2223.newsstand.domain;

import java.util.Objects;

import uo.mp.util.check.ArgumentChecks;
import uo.mp2223.newsstand.exception.NewsstandException;

public class Magazine extends Publication {
	
	
	
	public static int MIN_STOCK = 5;
	public static int MIN_ORDER = 20;

	private Frequency frequency;

	public Magazine(String name, int stock, int sales, Frequency freq) {
		super(name, stock, sales);
		ArgumentChecks.isTrue( freq != null);
		this.frequency = freq;
	}

	public Frequency getFrequency() {
		return frequency;
	}

	public String toString() {
		return super.toString() + "\t" + getFrequency();
	}

	@Override
	public String serialize() {
		return "magazine" 
				+ "\t" + getName() 
				+ "\t" + getStock() 
				+ "\t" + getSales() 
				+ "\t" + getFrequency();
	}

	@Override
	public Order generateOrders() throws NewsstandException {
		if(getStock() >= MIN_COPIES) {
			throw new NewsstandException("No es necesario pedir mas unidades de " + getName());
		}
		if (getStock() < MIN_STOCK) {
			return new Order(this.getName(), MIN_ORDER);
		} else {
			if (getFrequency() == Frequency.WEEKLY) {
				return new Order(this.getName(), getSales());
			} else {
				return new Order(this.getName(), getSales() + getStock());
			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(frequency);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		if(!super.equals(obj)) {
			return false;
		}
		Magazine other = (Magazine) obj;
		return frequency == other.frequency;
	}

}
