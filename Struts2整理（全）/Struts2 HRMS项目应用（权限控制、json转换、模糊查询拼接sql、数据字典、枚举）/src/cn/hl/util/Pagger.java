package cn.hl.util;

import java.util.List;

/**
 * 泛型类
 * @author Terry
 *
 * @param <T>
 */
public class Pagger<T> {
	//总记录数
	private int rows;
	//每页记录数
	private int pageSize;
	//总页数
	private int pageCount;
	//当前页索引
	private int index;
	private List<T> data;
	
	/**
	 * 无参构造函数，初始化默认每页记录数
	 */
	public Pagger() {
		this.pageSize = 5;
		this.index = 0;
	}

	/**
	 * 带参构造函数，初始化总记录数
	 * @param rows
	 */
	public Pagger(int rows) {
		this.index = 0;
		this.rows = rows;
		this.pageSize = 5;
	}

	/**
	 * 带参构造函数，初始化总记录数和当前页数
	 * @param rows
	 * @param index
	 */
	public Pagger(int rows, int index) {
		this.rows = rows;
		this.index = index;
		this.pageSize = 5;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getPageCount() {
		return 	pageCount=(int)Math.ceil(rows*1.0 / pageSize);
	}


	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Pagger [rows=" + rows + ", pageSize=" + pageSize
				+ ", pageCount=" + pageCount + ", index=" + index + ", data="
				+ data + "]";
	}


	
	
}
