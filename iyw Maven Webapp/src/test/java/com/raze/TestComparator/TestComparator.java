package com.raze.TestComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestComparator {
	
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("诸葛亮", 65, 72));
		list.add(new Student("刘备", 85, 36));
		list.add(new Student("曹操", 98, 99));
		list.add(new Student("张飞", 12, 32));
		list.add(new Student("关羽", 65, 72));
		list.add(new Student("孙权", 85, 69));
		list.add(new Student("周杰伦", 81, 25));
		list.add(new Student("葛优", 65, 72));
		list.add(new Student("刘德华", 72, 39));
		list.add(new Student("林心如", 79, 65));
		for(Student student: list){
			System.out.println(student);
		}
		System.out.println("======================================================");
		
		Collections.sort(list, new ComparatorImpl());
		
		for(Student student: list){
			System.out.println(student);
		}
	}

}
