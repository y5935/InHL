package cn.hl.dao;

import java.util.List;

import cn.hl.bean.User;

public interface UserDao {
/**
 * Dao�ӿ�
 * Լ��ʵ��Dao�Ĺ���
 * 1.Լ����Ա
 * 2.Լ������
 */
	public int add(User user);
	public int delete(int id);
	public int update(User user);
	public User getByAccount(String account ,String pwd);
}
