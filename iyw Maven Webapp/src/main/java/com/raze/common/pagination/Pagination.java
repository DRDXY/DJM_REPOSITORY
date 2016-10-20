package com.raze.common.pagination;

import java.io.Serializable;
import java.util.List;

/**
 * @author DJM
 */
public class Pagination<T> implements Serializable {

	private static final long serialVersionUID = -4817814886123631684L;

	/*Fields,start*/
	
	/*记录的总条数,受数据库中的记录影响,需通过SQL查询获取*/
	private Integer totalRecord;
	
	/*记录的总页数,受参数totalRecord与pageSize影响,可通过计算获取*/
	private Integer totalPages;
	
	/*每页显示记录的条数,需自主设置*/
	private Integer pageSize;
	
	/*当前页码值,可影响参数beginLine的值,需通过参数传递获取*/
	private Integer currentPage;
	
	/*limit参数,记录起始的index,受参数currentPage与pageSize影响,通过计算获取*/
	private Integer beginLine;
	
	/*分页处理之后,得到的结果集*/
	private List<T> summaryList;

	/*Fields,end*/
	
	
	/*Methods of getter and setter,start*/
	public Integer getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getBeginLine() {
		return beginLine;
	}

	public void setBeginLine(Integer beginLine) {
		this.beginLine = beginLine;
	}
	
	public List<T> getSummaryList() {
		return summaryList;
	}

	public void setSummaryList(List<T> summaryList) {
		this.summaryList = summaryList;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	/*Methods of getter and setter,end*/
	
	
	/**
	 * Constructor.
	 * @param totalRecord  the number of pages (required)
	 * @param pageSize numbers of display records(unnecessary,default 15)
	 * @param currentPage the current page 
	 */
	public Pagination(Integer totalRecord, Integer pageSize, Integer currentPage) {
		this.totalRecord = totalRecord==null? 0: totalRecord;
		this.pageSize = (pageSize==null||pageSize<=0)? IPageable.DEFAULT_SHOW_LINE: pageSize;
		this.totalPages = (this.totalRecord%this.pageSize==0||this.totalRecord==0)? this.totalRecord/this.pageSize: this.totalRecord/this.pageSize+1;
		this.currentPage = currentPage==null? 1: currentPage;
		this.beginLine = (this.currentPage-1)*this.pageSize;
	}
	/*Constructor,end*/
	
	/*Method of toString,start*/
	@Override
	public String toString() {
		return "Pagination [totalRecord=" + totalRecord + ", totalPages="
				+ totalPages + ", pageSize=" + pageSize + ", currentPage="
				+ currentPage + ", beginLine=" + beginLine + ", summaryList="
				+ summaryList + "]";
	}
	/*Method of toString,end*/

}
