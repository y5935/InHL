package cn.hl.action;



import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import cn.hl.vo.Address;

public class UserAction {
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Action(value="exec",results={@Result(name="success",location="/index.jsp")})
	public String execute(){
		System.out.println(address);
		return "success";
	}
}
