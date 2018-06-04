package cn.hl.dao;

import java.util.List;

import cn.hl.bean.User;

public interface UserDao {
/**
 * Dao接口
 * 约束实现Dao的功能
 * 1.约束成员
 * 2.约束命名
 */
	public int add(User user);
	public int delete(int id);
	public int update(User user);
	public User getByAccount(String account ,String pwd);
}
