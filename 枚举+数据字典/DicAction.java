package cn.hl.action;

import java.util.List;

import net.sf.json.JSONArray;
import cn.hl.commons.Sort;
import cn.hl.service.DicService;
import cn.hl.vo.Dic;

public class DicAction {
	private JSONArray root;
	
	private String sort = "";
	DicService service = new DicService();
	/**
	 * 
	 * @return
	 */
	public String getDept(){
		if("".equals(sort)) return "error";
		
		
		List<Dic> list = service.getBySort(Sort.valueOf(sort));
		root = JSONArray.fromObject(list);
		
		return "success";
	}	
	
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}

	public JSONArray getRoot() {
		return root;
	}

}
