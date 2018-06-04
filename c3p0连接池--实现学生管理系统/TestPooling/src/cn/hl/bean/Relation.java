package cn.hl.bean;

public class Relation {
	private int relId;
	private String name;
	private String relation;
	private String tel;
	private int stuNo;
	public Relation() {
	
	}
	public Relation(int stuNo){
		this.stuNo = stuNo;
	}
	
	public Relation(int relId, String name, String relation, String tel,
			int stuNo) {
		super();
		this.relId = relId;
		this.name = name;
		this.relation = relation;
		this.tel = tel;
		this.stuNo = stuNo;
	}

	public int getRelId() {
		return relId;
	}
	public void setRelId(int relId) {
		this.relId = relId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getStuNo() {
		return stuNo;
	}
	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}
	@Override
	public String toString() {
		return "Relation [relId=" + relId + ", name=" + name + ", relation="
				+ relation + ", tel=" + tel + ", stuNo=" + stuNo + "]";
	}
	
	
}
