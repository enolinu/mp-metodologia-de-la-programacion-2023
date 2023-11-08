package uo.mp2223.util.file;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import uo.mp2223.newsstand.exception.NotYetImplementedException;

/**
 * A utility class to read/write text lines from/to a text file
 */
public class FileUtil {

	public List<String> readLines(String inFileName) throws FileNotFoundException {
		
		List<String> res = new LinkedList<>();
		
		String line;
		BufferedReader in = new BufferedReader(new FileReader(inFileName));
		
		try {
			try {
				while((line = in.readLine()) != null) {
					res.add(line);
				}
			} finally {
				in.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		return res;
		
	}

	public void writeLines(String outFileName, List<String> lines) {
		
		throw new NotYetImplementedException();
	}

}
