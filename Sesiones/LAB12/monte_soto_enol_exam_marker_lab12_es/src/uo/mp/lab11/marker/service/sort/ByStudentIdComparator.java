package uo.mp.lab11.marker.service.sort;

import java.util.Comparator;
import uo.mp.lab11.marker.model.StudentMark;

public class ByStudentIdComparator implements Comparator<StudentMark> {

	@Override
	public int compare(StudentMark sm1, StudentMark sm2) {
		return sm1.getStudentId().compareTo(sm2.getStudentId());
	}

}
