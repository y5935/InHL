package cn.hl.action;

import java.util.List;

import net.sf.json.JSONArray;
import cn.hl.service.ResourceService;
import cn.hl.vo.Resource;


public class ResourceAction {
	private JSONArray root;
	
	ResourceService service = new ResourceService();
	
	/**
	 * 获取用户的导航菜单
	 * @return
	 */
	public String getNavigation(){
		//获取导航数据
		List<Resource> list = service.getNavigate();
		//将List对象转为JSONArray对象
		root = JSONArray.fromObject(list);
		
		return "success";
	}

	public JSONArray getRoot() {
		return root;
	}
}
