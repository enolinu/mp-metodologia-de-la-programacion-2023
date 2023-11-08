package uo.mp.newsstand.service.newsstand;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;


public class CreateOrdersTest {

	
	@BeforeEach
	public void setUp() throws Exception {
	}
	
	/**
	 * GIVEN: A newspaper with enough copies in stock 
	 * WHEN: generate orders
	 * THEN: no new order is generated
	 */
	@Test
	public void enoughCopiesNewspaperNoOrderTest() {
		fail();
	}

	/**
	 * GIVEN: A newspaper with copies in stock in the limit 
	 * WHEN: generate orders
	 * THEN: no new order is generated
	 */
	@Test
	public void copiesintheLimitNewspaperNoOrderTest() {
		fail();
	}
	
	/**
	 * GIVEN: A newspaper with no enough copies in stock 
	 * WHEN: generate orders
	 * THEN: new order is generated with name and 20
	 */
	@Test
	public void noEnoughCopiesNewspaperNoOrderTest() {
		fail();
	}

	/**
	 * GIVEN: A weekly magazine with enough copies in stock 
	 * WHEN: generate orders
	 * THEN: no new order is generated
	 */
	@Test
	public void enoughCopiesWeeklyMagazineNoOrderTest() {
		fail();
	}
	
	/**
	 * GIVEN: A weekly magazine with copies in stock in the limit 
	 * WHEN: generate orders
	 * THEN: no new order is generated
	 */
	@Test
	public void limitCopiesWeeklyMagazineNoOrderTest() {
		fail();
	}
	
	/**
	 * GIVEN: A weekly magazine with copies in stock under 5 
	 * WHEN: generate orders
	 * THEN: order is generated to order 20 copies 
	 */
	@Test
	public void weeklyMagazineCopiesUnder5Order20() {
		fail();
	}
	
	/**
	 * GIVEN: A weekly magazine with copies in stock equals 5
	 * WHEN: generate orders
	 * THEN: order is generated to order number of copies sold
	 */
	@Test
	public void weeklyMagazine5CopiesOrderSold() {
		fail();
	}
	
	
	
	/**
	 * GIVEN: A monthly magazine with enough copies in stock 
	 * WHEN: generate orders
	 * THEN: no new order is generated
	 */
	@Test
	public void enoughCopiesMonthlyMagazineNoOrderTest() {
		fail();
	}
	
	/**
	 * GIVEN: A monthly magazine with copies in stock in the limit (10)
	 * WHEN: generate orders
	 * THEN: no new order is generated
	 */
	@Test
	public void limitCopiesMonthlyMagazineNoOrderTest() {
		fail();
	}
	
	/**
	 * GIVEN: A monthly magazine with copies in stock under 5 
	 * WHEN: generate orders
	 * THEN: order is generated to order 20 copies 
	 */
	@Test
	public void monthlyMagazineCopiesUnder5Order20() {
		fail();
	}
	
	/**
	 * GIVEN: A monthly magazine with copies in stock equals 5
	 * WHEN: generate orders
	 * THEN: order is generated to order number of copies sold +
	 * 									  number of copies in stock
	 */
	@Test
	public void monthlyMagazine5CopiesOrderSoldPlusStock() {
		fail();
	}
	
}
