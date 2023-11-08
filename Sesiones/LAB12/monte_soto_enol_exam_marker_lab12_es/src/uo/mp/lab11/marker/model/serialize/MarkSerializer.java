package uo.mp.lab11.marker.model.serialize;

import java.util.ArrayList;
import java.util.List;

import uo.mp.lab11.marker.model.StudentMark;

public class MarkSerializer {
	
	public List<String> serialize(List<StudentMark> marks) {
		
		List<String> lines = new ArrayList<>();
		
		for(StudentMark mark: marks) {
			lines.add(mark.serialize());
		}
		
		return lines;
		
	}

}
