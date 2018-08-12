package cn.hl.converter;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import cn.hl.vo.Address;

public class AddressConverter extends StrutsTypeConverter{

	/**
	 * 从字符串进行转换
	 */
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		System.out.println("convert is do......");
		if(values.length >0){
			String[] arr = values[0].split(",");
			
			System.out.println(arr.length);
			if(arr.length==3)
				return new Address(arr[0],arr[1],arr[2]);
			else 
				return null;
		}
		
		return null;
	}

	/**
	 * 转换为字符串
	 */
	@Override
	public String convertToString(Map context, Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
