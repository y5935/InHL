package cn.hl.dao;

import java.util.List;

import cn.hl.db.BaseDao;
import cn.hl.vo.Dic;

public class DicDao extends BaseDao{
	/**
	 * 按照分类查询数据
	 * @param sort
	 * @return
	 */
	public List<Dic> getBySort(int sort){
		String sql = "select * from sys_dic where sort=?";
		
		return this.executeQuery(Dic.class, sql, sort);
	}
}
