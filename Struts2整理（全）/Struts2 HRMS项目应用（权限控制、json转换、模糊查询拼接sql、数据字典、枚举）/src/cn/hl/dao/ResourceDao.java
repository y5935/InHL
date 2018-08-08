package cn.hl.dao;

import java.util.List;

import cn.hl.db.BaseDao;
import cn.hl.vo.Resource;

public class ResourceDao extends BaseDao{
	/**
	 * 查询所有有效菜单项
	 * @return
	 */
	public List<Resource> getAll(){
		//编写SQL语句
		String sql = "select * from sys_resource where state=1";
		
		return this.executeQuery(Resource.class, sql);
	}
}
