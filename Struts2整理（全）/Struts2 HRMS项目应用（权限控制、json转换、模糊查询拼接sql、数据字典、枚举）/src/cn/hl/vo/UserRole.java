package cn.hl.vo;

public class UserRole {
	private int id;
	private int userId;
	private int roleId;
	
	public UserRole() {
		// TODO Auto-generated constructor stub
	}

	public UserRole(int id, int userId, int roleId) {
		super();
		this.id = id;
		this.userId = userId;
		this.roleId = roleId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
}
