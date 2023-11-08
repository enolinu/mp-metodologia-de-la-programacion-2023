package uo.mp.lab11.marker.service.sort;

import java.util.Comparator;

import uo.mp.lab11.marker.model.StudentMark;

public class ByMarkAndIdComparator implements Comparator<StudentMark> {

	@Override
	public int compare(StudentMark sm1, StudentMark sm2) {
		
		// Ojo que se puede poner así porque tenemos el compare del Comparable con la nota.
		int byMark =  sm1.compareTo(sm2);
		
		if(byMark == 0) {
			return sm1.getStudentId().compareTo(sm2.getStudentId());
		}
		
		return byMark;
		
		
	}

}
