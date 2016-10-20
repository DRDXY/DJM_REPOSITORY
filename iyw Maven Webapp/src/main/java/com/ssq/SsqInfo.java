package com.ssq;

import java.io.Serializable;

public class SsqInfo implements Serializable {
	
	private static final long serialVersionUID = 9133859394897803208L;

	private String issue;
	
	private String opend;
	
	private String red;
	
	private String blue;
	
	private Integer sum_only_red;
	
	private Integer sum_with_blue;
	
	private Float average_only_red;
	
	private Float average_with_blue;

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getOpend() {
		return opend;
	}

	public void setOpend(String opend) {
		this.opend = opend;
	}

	public String getRed() {
		return red;
	}

	public void setRed(String red) {
		this.red = red;
	}

	public String getBlue() {
		return blue;
	}

	public void setBlue(String blue) {
		this.blue = blue;
	}

	public Integer getSum_only_red() {
		return sum_only_red;
	}

	public void setSum_only_red(Integer sum_only_red) {
		this.sum_only_red = sum_only_red;
	}

	public Integer getSum_with_blue() {
		return sum_with_blue;
	}

	public void setSum_with_blue(Integer sum_with_blue) {
		this.sum_with_blue = sum_with_blue;
	}

	public Float getAverage_only_red() {
		return average_only_red;
	}

	public void setAverage_only_red(Float average_only_red) {
		this.average_only_red = average_only_red;
	}

	public Float getAverage_with_blue() {
		return average_with_blue;
	}

	public void setAverage_with_blue(Float average_with_blue) {
		this.average_with_blue = average_with_blue;
	}

	@Override
	public String toString() {
		return "SsqInfo [issue=" + issue + ", opend=" + opend + ", red=" + red
				+ ", blue=" + blue + ", sum_only_red=" + sum_only_red
				+ ", sum_with_blue=" + sum_with_blue + ", average_only_red="
				+ average_only_red + ", average_with_blue=" + average_with_blue
				+ "]";
	}

}
