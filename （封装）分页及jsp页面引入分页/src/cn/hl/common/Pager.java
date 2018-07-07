package cn.hl.common;

import java.util.List;

public class Pager<T> {
	//私有成员字段
	//总记录数（setter方法即可）
	private int rows;
	//每页记录数（setter方法即可）
	private int pageSize;
	//当前页索引
	private int index;
	//总页数
	private int pages;
	//是否为第一页
	private boolean first;
	//是否为末页
	private boolean last;
	//新纪录位置的偏移量
	private int offSet;
	//查询结果的集合
	private  List<T> list;
	
	//构造函数
	/**
	 * 无参构造函数
	 */
	public Pager() {}

	/**
	 * 带参构造函数
	 * @param rows		：总记录数
	 * @param pageSize	：每页记录数
	 */
	public Pager(int rows, int pageSize) {
		this.rows = rows;
		this.pageSize = pageSize;
	}

	/**
	 * 带参构造函数
	 * @param rows		：总记录数
	 * @param pageSize	：每页记录数
	 * @param index		：当前页索引
	 */
	public Pager(int rows, int pageSize, int index) {
		this.rows = rows;
		this.pageSize = pageSize;
		this.index = index;
	}

	//get/set访问器
	/**
	 * 判断是否为第一页
	 * 如果索引位置为1，则表示已经是首页
	 * @return
	 */
	public boolean isFirst() {
		return (this.first=(this.index ==1));
	}

	/**
	 * 判断是否为最后一页
	 * 当前页索引与最大页码数相等，则表示已经是末页
	 * @return
	 */
	public boolean isLast() {
		return (this.last=(this.index == this.pages));
	}
	
	/**
	 * 返回总页面数
	 * @return
	 */
	public int getPages() {
		return (pages =((int)Math.ceil(this.rows * 1.0 / this.pageSize)));
	}
	
	/**
	 * 设置总记录数
	 * @param rows
	 */
	public void setRows(int rows) {
		this.rows = rows;
	}
	
	/**
	 * 设置每页记录数
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 获取每页记录数
	 * @return
	 */
	public int getPageSize(){
		return this.pageSize;
	}
	
	/**
	 * 获取当前页的索引
	 * @return
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * 设置当前页的索引
	 * @param index
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * 获取当前数据的集合
	 * @return
	 */
	public List<T> getList() {
		return list;
	}

	/**
	 * 设置分页数据
	 * @param list
	 */
	public void setList(List<T> list) {
		this.list = list;
	}
	
	/**
	 * 获取记录的偏移量
	 * @return
	 */
	public int getOffSet() {
		return (this.index-1) * this.pageSize;
	}
}
