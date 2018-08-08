package cn.hl.vo;

public class Dic {
	private int dicId;
	private String title;
	private int sort;
	private int state;
	
	public Dic() {
		// TODO Auto-generated constructor stub
	}

	public int getDicId() {
		return dicId;
	}

	public void setDicId(int dicId) {
		this.dicId = dicId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Dic [dicId=" + dicId + ", title=" + title + ", sort=" + sort
				+ ", state=" + state + "]";
	}
}
