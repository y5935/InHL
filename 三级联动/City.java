package cn.hl.bean;

public class City {
	private int id;
	private String name;
	private int pId;
	
	public City() {
	}

	public City(int id, String name, int pId) {
		this.id = id;
		this.name = name;
		this.pId = pId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}
	
}
