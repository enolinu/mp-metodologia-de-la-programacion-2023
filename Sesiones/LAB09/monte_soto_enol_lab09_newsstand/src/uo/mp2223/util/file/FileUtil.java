package uo.mp2223.util.file;



import java.util.LinkedList;
import java.util.List;

import uo.mp2223.newsstand.exception.NotYetImplementedException;

/**
 * A utility class to read/write text lines from/to a text file
 */
public class FileUtil {

	public List<String> readLines(String inFileName) {
		
		List<String> res = new LinkedList<>();
		
		res.add("newspaper	La Nueva España	14	30");
		res.add("newspaper	El Mundo	4	10"); 
		
		// Líneas erróneas.
		res.add("      "); 
		res.add("news	El Mundo	4	10"); 
		res.add("newspaper	El Mundo	4g	10"); 
		res.add("newspaper	El Mundo"); 
		
		res.add("magazine	Hola	14	30	BIMONTHLY"); 
		res.add("magazine	PCWord	14	30	QUARTERLY");
		res.add("magazine	Diez Minuntos	4	10	WEEKLY"); 
		res.add("magazine	El Mueble	4	10	MONTHLY");
		res.add("magazine	Muy Interesante	8	20	DAILY");
		res.add("magazine	Quo	8	10	BIMONTHLY");
		
		return res;
		
	}

	public void writeLines(String outFileName, List<String> lines) {
		
		throw new NotYetImplementedException();
	}

}
