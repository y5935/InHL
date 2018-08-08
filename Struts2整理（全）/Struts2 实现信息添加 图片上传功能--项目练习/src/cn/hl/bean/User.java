package cn.hl.bean;

public class User {
	private int userId;
	private String name;
	private boolean gender;
	private int age;
	private String tel;
	private String photo;
	private String address;
	private String idCard;
	
	public User() {
	}

	public User(int userId, String name, boolean gender, int age, String tel,
			String photo, String address, String idCard) {
		this.userId = userId;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.tel = tel;
		this.photo = photo;
		this.address = address;
		this.idCard = idCard;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", gender="
				+ gender + ", age=" + age + ", tel=" + tel + ", photo=" + photo
				+ ", address=" + address + ", idCard=" + idCard + "]";
	}
}
