package cn.hl.service;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import cn.hl.dao.UserDao;
import cn.hl.vo.User;

public class UserService {
	UserDao dao = new UserDao();
	
	/**
	 * 执行用户登录验证
	 * 通过验证后会将用户数据添加到作用域中
	 * @param account：账号
	 * @param pwd	   ：密码
	 * @return		   ：0、用户名错误；1、密码错误；2、验证成功
	 */
	public int login(String account,String pwd){
		//通过account查询用户数据
		List<User> list = dao.findByAccount(account);
		
		//验证查询结果
		//用户集合为空：账号不存在或处于冻结状态
		if(list.size()==0){
			return 0;
		}
		else{
			//遍历集合中的每一个用户信息
			for(User user : list){
				//验证密码是否正确
				if(pwd.equals(user.getPwd())){
					//将用户信息存储到Session中
					ActionContext.getContext().getSession().put("user", user);
					return 2;
				}
			}
			
			//遍历集合中所有元素后，无匹配数据则表示密码错误
			return 1;
		}
	}
}
