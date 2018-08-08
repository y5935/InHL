package cn.hl.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.hl.vo.Resource;

public class TreeParse {
	/**
	 * 将制定集合对象转为Tree集合对象
	 * @param parentId
	 * @param list
	 * @return
	 */
	public List<Resource> toTreeList(int parentId,Set<String> userSet,List<Resource> entityList){
		//存储符合条件的菜单项
		List<Resource> list= new ArrayList<Resource>();
		//存储当前用户具有权限的所有菜单项
		List<Resource> newList = new ArrayList<Resource>();
		
		//过滤所有具有权限的菜单项
		for(Resource res : entityList){
			//将菜单项的权限列表转为数组对象
			String[] arr = res.getRoles().split("/");
			//将数组对象转为Set集合对象
			Set<String> resSet = new HashSet<String>(Arrays.asList(arr));
			//调用Set集合对象的retainAll()方法获取集合的交集
			resSet.retainAll(userSet);
			//是否具有权限，如果有则将菜单项添加到newList集合中
			if(resSet.size()>0)
				newList.add(res);
		}
		
		//遍历entityList集合找出所有一级菜单
		for(Resource res : newList){
			//如果当前菜单项与parentId相同则添加到list集合中
			if(parentId == res.getParentId()){
				//查询当前列表的子集菜单项并添加到当前菜单集合中
				res.setChildList(this.getSubList(res.getResId(),newList));
				list.add(res);
			}
		}
		
		return list;
	}
	
	/**
	 * 获取子级菜单集合
	 * @param parentId
	 * @param entityList
	 * @return
	 */
	public List<Resource> getSubList(int parentId,List<Resource> entityList){
		//存储符合条件的菜单项
		List<Resource> list = new ArrayList<Resource>();
		
		//遍历entityList集合找出所有符合条件的子菜单项
		for(Resource res : entityList){
			//符合条件的添加到list集合中准备进行返回
			if(parentId == res.getParentId()){
				list.add(res);
			}
		}
		
		
		return list;
	}
}
