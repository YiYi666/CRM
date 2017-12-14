package com.zy.crm.entity;

import java.util.List;

public class Page<T> {
	
	private Integer pageNo;
	private Integer pageSize;
	private Integer totalPage;
	private Integer count;
	private List<T> datas;
	
	public Page() {
		super();
	}
	
	public Page(String pageNo,Integer pageSize,Integer count) {
		super();
		this.totalPage = count%pageSize==0 ? count/pageSize : count/pageSize+1;
		if(pageNo==null||pageNo.isEmpty()){
			this.pageNo = 1;
		}else if(Integer.parseInt(pageNo)<1) {
			this.pageNo = 1;
		}else if(Integer.parseInt(pageNo)>totalPage) {
			this.pageNo=totalPage;
		}else{
			this.pageNo = Integer.parseInt(pageNo);
		}
		this.pageSize = pageSize;
		this.count = count;
	}

	public Integer getPageNo() {
		if(pageNo<1) {
			pageNo=1;
		}else if(pageNo>totalPage) {
			pageNo=totalPage;
		}
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	public Integer getBeginRow(){
		return (pageNo-1)*pageSize;
	}

/*	public Integer getPrePageNo(){
		if(pageNo>1) {
			
			pageNo= pageNo-1;
		}
		return pageNo;
	}
	public Integer getNextPageNo(){
		if(pageNo<totalPage) {
			pageNo= pageNo+1;
		}
		return pageNo;
	}*/
	
}
