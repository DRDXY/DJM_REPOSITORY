package com.raze.TestComparator;

import java.util.Comparator;

public class ComparatorImpl implements Comparator<Student> {

	@Override
	public int compare(Student student1, Student student2) {
		int student1Score = student1.getChineseScore()+student1.getMathematicsScore();
		int student2Score = student2.getChineseScore()+student2.getMathematicsScore();
		if(student1Score>student2Score){
			return 1;
		}
		if(student1Score<student2Score){
			return -1;
		}
		return 0;
	}

}
