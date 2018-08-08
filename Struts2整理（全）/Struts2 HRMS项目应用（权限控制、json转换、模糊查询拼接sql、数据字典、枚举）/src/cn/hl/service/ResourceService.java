package cn.hl.service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.hl.dao.ResourceDao;
import cn.hl.dao.UserRoleDao;
import cn.hl.util.TreeParse;
import cn.hl.vo.Resource;
import cn.hl.vo.User;
import cn.hl.vo.UserRole;

import com.opensymphony.xwork2.ActionContext;

public class ResourceService {
	ResourceDao dao = new ResourceDao();
	/**
	 * 按照用户角色获取用户导航菜单列表
	 * @return
	 */
	public List<Resource> getNavigate(){
		//存储导航项列表
		List<Resource> list =null;
		//获取applicaiton对象
		Map<String,Object> map = ActionContext.getContext().getApplication();
		
		//从Application作用域中读取导航资源集合
		if(map.containsKey("resource"))
			//如果Application中已经包含了resource项则直接进行读取
			list = (List<Resource>)map.get("resource");
		else{
			//从数据库中读取资源对象
			list = dao.getAll();
			//将资源对象存储到application作用域以便后续使用
			ActionContext.getContext().getApplication().put("resource", list);
		}
		
		//获取作用域中的User对象
		User user = (User)ActionContext.getContext().getSession().get("user");
		
		//获取用户角色集合
		UserRoleDao roleDao = new UserRoleDao();
		//根据UserId查询用户角色列表
		List<UserRole> roleList = roleDao.getByUserId(user.getUserId());
		
		//获取用户角色的set集合
		Set<String> set = new HashSet<String>();
		//将角色集合转为Set集合
		for(UserRole role : roleList){
			set.add(Integer.toString(role.getRoleId()));
		}
		
		//实例化TreeParse对象，准备获取导航树对象
		TreeParse parse = new TreeParse();
		//返回导航树对象
		return parse.toTreeList(0,set, list);
	}
}

