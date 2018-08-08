package cn.hl.bean;

public class Grade {
	private String gradeId;
	private String gradeName;
	
	public Grade() {
		// TODO Auto-generated constructor stub
	}

	public Grade(String gradeId, String gradeName) {
		super();
		this.gradeId = gradeId;
		this.gradeName = gradeName;
	}

	public String getGradeId() {
		return gradeId;
	}

	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	
	
}
