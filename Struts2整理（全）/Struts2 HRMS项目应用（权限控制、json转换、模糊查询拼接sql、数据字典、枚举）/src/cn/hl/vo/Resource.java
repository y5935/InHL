package cn.hl.vo;

import java.util.List;

public class Resource {
	private int resId;
	private String title;
	private String url;
	private String icon;
	private int parentId;
	private String roles;
	private int state;
	private List<Resource> childList;
	
	public Resource() {
		// TODO Auto-generated constructor stub
	}
	
	public Resource(int resId, String title, String url, String icon,
			int parentId, String roles, int state, List<Resource> childList) {
		super();
		this.resId = resId;
		this.title = title;
		this.url = url;
		this.icon = icon;
		this.parentId = parentId;
		this.roles = roles;
		this.state = state;
		this.childList = childList;
	}


	public int getResId() {
		return resId;
	}

	public void setResId(int resId) {
		this.resId = resId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public List<Resource> getChildList() {
		return childList;
	}

	public void setChildList(List<Resource> childList) {
		this.childList = childList;
	}

	@Override
	public String toString() {
		return "Resource [resId=" + resId + ", title=" + title + ", url=" + url
				+ ", icon=" + icon + ", parentId=" + parentId + ", roles="
				+ roles + ", state=" + state + ", childList=" + childList + "]";
	}


	
}
