package cn.hl.service;

import java.util.List;

import cn.hl.commons.Sort;
import cn.hl.dao.DicDao;
import cn.hl.vo.Dic;



public class DicService {
	DicDao dao = new DicDao();
	
	/**
	 * 获取相关数据
	 * 	Enum（枚举）
	 * @param sort
	 * @return
	 */
	public List<Dic> getBySort(Sort sort){
		if(sort == Sort.DEPARTMENT)
			return dao.getBySort(5);
		else if(sort== Sort.POSITION)
			return dao.getBySort(4);
		else if(sort == Sort.EDUCATION)
			return dao.getBySort(1);
		else if(sort == Sort.DEGREE)
			return dao.getBySort(2);
		else 
			return null;
	}
}
