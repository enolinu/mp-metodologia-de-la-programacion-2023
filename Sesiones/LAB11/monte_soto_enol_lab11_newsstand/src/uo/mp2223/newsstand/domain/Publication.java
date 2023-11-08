package uo.mp2223.newsstand.domain;


import uo.mp.util.check.ArgumentChecks;
import uo.mp2223.newsstand.exception.NewsstandException;

public abstract class Publication implements Comparable<Publication> {
	
	protected static final int MIN_COPIES = 10;
	
	private String name;
	private int instock;
	private int sales;

	public Publication(String name, int stock, int sales) {
		ArgumentChecks.isTrue( name != null );
		ArgumentChecks.isTrue( name.trim().isEmpty() == false );
		ArgumentChecks.isTrue( stock > 0 );
		ArgumentChecks.isTrue( sales > 0 );
		this.name = name;
		this.instock = stock;
		this.sales = sales;
	}

	public abstract Order generateOrders() throws NewsstandException;
	public abstract String serialize();

	public String getName() {
		return name;
	}

	public int getStock() {
		return instock;
	}

	public int getSales() {
		return sales;
	}

	public String toString() {
		return getName() + "\t" + getStock() + "\t" + getSales();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publication other = (Publication) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Publication p) {
		// ArgumentChecks...
		return  this.getName().compareTo(p.getName());
	}

}
