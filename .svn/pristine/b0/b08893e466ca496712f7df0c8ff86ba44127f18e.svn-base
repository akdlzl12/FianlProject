package com.es.common.vo;

public class Pagination {
	private Integer pageNo;
	
	private String opt;
	private String keyword;
	
	private Integer pagePerBlock = 5;
	private Integer rowPerPage = 15;
	private Integer totalItems;
	
	public Integer getBeginIndex() {
		return 1 + (pageNo - 1) * rowPerPage;
	}
	
	public Integer getEndIndex() {
		int endIndex = pageNo * rowPerPage;
		if(pageNo == getEndPage())
			return totalItems < endIndex ? endIndex : totalItems;
		else return endIndex;
	}
	
	public Integer getBeginPage() {
		return 1 + (getCurrentBlock() - 1) * pagePerBlock;
	}
	public Integer getEndPage() {
		int blockLastPage = getCurrentBlock() * pagePerBlock;
		int lastPage = getLastPage(); 
		if(blockLastPage > lastPage)
			return lastPage;
		else return blockLastPage;
	}
	public Integer getLastPage() {
		return (int) Math.ceil(totalItems / (double)rowPerPage);
	}
	
	public Integer getCurrentBlock() {
		return (int) Math.ceil(pageNo / (double)pagePerBlock);
	}
	public Integer getEndBlock() {
		return (int) Math.ceil(getLastPage() / (double)pagePerBlock);
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public String getOpt() {
		return opt;
	}

	public void setOpt(String opt) {
		this.opt = opt;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getPagePerBlock() {
		return pagePerBlock;
	}

	public void setPagePerBlock(Integer pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}

	public Integer getRowPerPage() {
		return rowPerPage;
	}

	public void setRowPerPage(Integer rowPerPage) {
		this.rowPerPage = rowPerPage;
	}

	public Integer getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
	}

	@Override
	public String toString() {
		return "Pagination [pageNo=" + pageNo + ", opt=" + opt + ", keyword=" + keyword + ", pagePerBlock="
				+ pagePerBlock + ", rowPerPage=" + rowPerPage + ", totalItems=" + totalItems + "beginIndex="+getBeginIndex()+", endIndex="+getEndIndex()+"]";
	}
	
	@Override
	public boolean equals(Object obj) {
		Pagination pagination = (Pagination) obj; 
		if(this.opt == null ) {
			if(this.getBeginIndex() == pagination.getBeginIndex() && this.getEndIndex() == pagination.getEndIndex())
				return true;
		}
		return false;
	}
	
}
