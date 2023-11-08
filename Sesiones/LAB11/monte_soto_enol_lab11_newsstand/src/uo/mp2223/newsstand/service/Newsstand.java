package uo.mp2223.newsstand.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import uo.mp.util.check.ArgumentChecks;
import uo.mp2223.newsstand.domain.Order;
import uo.mp2223.newsstand.domain.Publication;
import uo.mp2223.newsstand.exception.NewsstandException;
import uo.mp2223.newsstand.exception.NotYetImplementedException;
import uo.mp2223.newsstand.service.parsers.PublicationParser;
import uo.mp2223.newsstand.service.serializers.OrderSerializer;
import uo.mp2223.newsstand.service.serializers.PublicationSerializer;
import uo.mp2223.newsstand.service.sort.ByNameAndQuantityOrdersComarator;
import uo.mp2223.newsstand.service.sort.BySalesPublicationComparator;
import uo.mp2223.util.file.FileUtil;
import uo.mp2223.util.file.ZipFileUtil;
import uo.mp2223.util.log.Logger;

public class Newsstand {

	private static final int MIN_FILE_LENGTH = 5;
	private List<Publication> publications = new LinkedList<>();
	private List<Order> orders = new LinkedList<>();

	/**
	 * Loads all the products contained in the file into publications.
	 * None publication can be repeated regarding its name. If a publication
	 * is with a repeated name is already registered it will be ignored 
	 * and a message sent to log.
	 * 
	 * @param inFileName, the name of the file
	 * @throws NewsstandException, if the file name is invalid
	 * @throws FileNotFoundException 
	 */
	public void loadFile(String inFileName) throws NewsstandException, FileNotFoundException {
		ArgumentChecks.isTrue(inFileName != null && !inFileName.isBlank());
		checkFilenameLen(inFileName);
		List<String> lines = new FileUtil().readLines(inFileName);
		List<Publication> fileProducts = new PublicationParser().parse(lines);
		addPublications(fileProducts);
	}

	private void checkFilenameLen(String inFileName) throws NewsstandException {
		if(inFileName.length() < MIN_FILE_LENGTH) {
			throw new NewsstandException(String.format("Longitud de %s menor de %d", inFileName, MIN_FILE_LENGTH));
		}
		
	}

	/**
	 * Add all the publications contained on the list passed as argument.
	 * None publication can be repeated regarding its name. If a publication
	 * is with a repeated name is already registered it will be ignored 
	 * and a message sent to log.
	 * 
	 * @param newProducts, the list with the new publications
	 */
	private void addPublications(List<Publication> newProducts) {
		for (Publication p : newProducts) {
			try {
				addPublication(p);
			} catch (NewsstandException e) {
				Logger.log(e.getMessage());
			}
		}
	}

	/**
	 * Add the publication if it is name is not already registered
	 * @param p, the product to be added
	 * @throws NewsstandException if the product's name is repeated
	 */
	public void addPublication(Publication p) throws NewsstandException {
		
		if(searchByName(p.getName()) == -1) {
			publications.add(p);
		}
		
		else {
			throw new NewsstandException(String.format("Publicación %s repetida", p.getName()));
		}
		
	}

	/**
	 * Removes the product whose indicated by its name
	 * 
	 * @param name of the publication to be removed
	 * @throws NewsstandException 
	 * @throws NewsstandExceptionif the product does not exist
	 */
	public void removePublication(String name) throws NewsstandException {
		
		int pos = searchByName(name);
		
		if(pos != -1) {
			publications.remove(pos);
		}
		
		else {
			throw new NewsstandException(String.format("Publicacion %s no existe", name));
		}
	}

	private int searchByName(String name) {
		for (int i = 0; i < publications.size(); i++) {
			Publication p = publications.get(i);
			if ((p.getName().equals(name)) /* compare both names */ )
				return i;
		}
		return -1;
	}

	/**
	 * @return a list which a copy of the internal list of publications
	 */
	public List<Publication> getPublications() {
		// Returns a list, copy of our own list to not break the encapsulation
		// A copy constructor needed in our lists
		return new ArrayList<>(publications);

	}

	/**
	 * Generates a list of orders. One for every product with stock under limits
	 */
	public void createOrders() {
		orders.clear();
		for(Publication p: publications) {
			try {
				Order order = p.generateOrders();
				orders.add(order);
			} catch (NewsstandException e) {
				Logger.log(e.getMessage());
			}
		}
		throw new NotYetImplementedException();
	}

	/**
	 * @return a list which a copy of the internal list of orders
	 */
	public List<Order> getOrders() {
		// Returns a list, copy of our own list to not break the encapsulation
		// A copy constructor needed in our lists
		return new ArrayList<>(orders);
	}

	/**
	 * Save all orders to a file with the given format
	 * 
	 * @param fileName
	 * @throws NewsstandException in case
	 * 		- the file name is invalid
	 */
	public void saveOrdersToFile(String fileName) throws NewsstandException {
		
		ArgumentChecks.isTrue(fileName != null && !fileName.isBlank());
		
		OrderSerializer serializer = new OrderSerializer();
		List<String> lines = serializer.serialize(orders);
		new FileUtil().writeLines(fileName, lines);
	}

	/**
	 * Imports all the publications from the zip file and removes all the 
	 * previous ones.
	 * 
	 * @param fileName
	 * @throws IOException 
	 */
	public void importPublicationsFromZipFile(String fileName) throws FileNotFoundException {
		ZipFileUtil fu = new ZipFileUtil();
		List<String> lines = fu.readLines(fileName);
		
		publications.clear();
		PublicationParser pp = new PublicationParser();
		List<Publication> publications = pp.parse(lines);
		publications.addAll(publications);
	}

	/**
	 * Saves all the publications to a zip file. The file produced can be read
	 * by the method @see importPublicationsFromZipFile
	 * 
	 * @param fileName
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void exportPublicationsToZipFile(String fileName) {
		PublicationSerializer serializer = new PublicationSerializer();
		List<String> lines = serializer.serialize(publications);
		new ZipFileUtil().writeLines(fileName, lines);
	}

	public void sortPublicationsByName() {
		Collections.sort(publications);
	}

	public void sortPublicationsBySales() {
		// lista, comparador
		Collections.sort(publications, new BySalesPublicationComparator());
	}

	public void sortOrdersByNameAndQuantity() {
		Collections.sort(orders, new ByNameAndQuantityOrdersComarator());
	}

}
