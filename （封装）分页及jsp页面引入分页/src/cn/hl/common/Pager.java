package cn.hl.common;

import java.util.List;

public class Pager<T> {
	//˽�г�Ա�ֶ�
	//�ܼ�¼����setter�������ɣ�
	private int rows;
	//ÿҳ��¼����setter�������ɣ�
	private int pageSize;
	//��ǰҳ����
	private int index;
	//��ҳ��
	private int pages;
	//�Ƿ�Ϊ��һҳ
	private boolean first;
	//�Ƿ�Ϊĩҳ
	private boolean last;
	//�¼�¼λ�õ�ƫ����
	private int offSet;
	//��ѯ����ļ���
	private  List<T> list;
	
	//���캯��
	/**
	 * �޲ι��캯��
	 */
	public Pager() {}

	/**
	 * ���ι��캯��
	 * @param rows		���ܼ�¼��
	 * @param pageSize	��ÿҳ��¼��
	 */
	public Pager(int rows, int pageSize) {
		this.rows = rows;
		this.pageSize = pageSize;
	}

	/**
	 * ���ι��캯��
	 * @param rows		���ܼ�¼��
	 * @param pageSize	��ÿҳ��¼��
	 * @param index		����ǰҳ����
	 */
	public Pager(int rows, int pageSize, int index) {
		this.rows = rows;
		this.pageSize = pageSize;
		this.index = index;
	}

	//get/set������
	/**
	 * �ж��Ƿ�Ϊ��һҳ
	 * �������λ��Ϊ1�����ʾ�Ѿ�����ҳ
	 * @return
	 */
	public boolean isFirst() {
		return (this.first=(this.index ==1));
	}

	/**
	 * �ж��Ƿ�Ϊ���һҳ
	 * ��ǰҳ���������ҳ������ȣ����ʾ�Ѿ���ĩҳ
	 * @return
	 */
	public boolean isLast() {
		return (this.last=(this.index == this.pages));
	}
	
	/**
	 * ������ҳ����
	 * @return
	 */
	public int getPages() {
		return (pages =((int)Math.ceil(this.rows * 1.0 / this.pageSize)));
	}
	
	/**
	 * �����ܼ�¼��
	 * @param rows
	 */
	public void setRows(int rows) {
		this.rows = rows;
	}
	
	/**
	 * ����ÿҳ��¼��
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * ��ȡÿҳ��¼��
	 * @return
	 */
	public int getPageSize(){
		return this.pageSize;
	}
	
	/**
	 * ��ȡ��ǰҳ������
	 * @return
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * ���õ�ǰҳ������
	 * @param index
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * ��ȡ��ǰ���ݵļ���
	 * @return
	 */
	public List<T> getList() {
		return list;
	}

	/**
	 * ���÷�ҳ����
	 * @param list
	 */
	public void setList(List<T> list) {
		this.list = list;
	}
	
	/**
	 * ��ȡ��¼��ƫ����
	 * @return
	 */
	public int getOffSet() {
		return (this.index-1) * this.pageSize;
	}
}
