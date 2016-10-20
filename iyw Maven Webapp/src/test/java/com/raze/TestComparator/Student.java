package com.raze.TestComparator;

import java.io.Serializable;

public class Student implements Serializable {
	
	private static final long serialVersionUID = 6744386721079823646L;

	private String name;
	
	private Integer chineseScore;
	
	private Integer mathematicsScore;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getChineseScore() {
		return chineseScore;
	}

	public void setChineseScore(Integer chineseScore) {
		this.chineseScore = chineseScore;
	}

	public Integer getMathematicsScore() {
		return mathematicsScore;
	}

	public void setMathematicsScore(Integer mathematicsScore) {
		this.mathematicsScore = mathematicsScore;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", chineseScore=" + chineseScore
				+ ", mathematicsScore=" + mathematicsScore + ", getName()="
				+ getName() + ", getChineseScore()=" + getChineseScore()
				+ ", getMathematicsScore()=" + getMathematicsScore()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public Student(String name, Integer chineseScore, Integer mathematicsScore) {
		super();
		this.name = name;
		this.chineseScore = chineseScore;
		this.mathematicsScore = mathematicsScore;
	}
	
}
