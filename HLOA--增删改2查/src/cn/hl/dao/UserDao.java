package cn.hl.dao;

import java.util.List;

import cn.hl.bean.User;
import cn.hl.db.BaseDao;

public class UserDao extends BaseDao{
	/**
	 * �����û���Ϣ
	 * @param user
	 * @return
	 */
	public int add(User user){
		//��дsql���
		String sql = "insert into Users values(default,?,?,?)";
		
		//����executeUpdate����
		return this.executeUpdate(sql, user.getAccount(),user.getPwd(),user.getUserName());
	}
	
	/**
	 * ��Id�����û���Ϣ
	 * @param user
	 * @return
	 */
	public int update(User user){
		String sql = "update users set userName=?,account=?,pwd=? where userId=?";
		
		//ִ��SQL���
		return this.executeUpdate(sql, user.getUserName(),user.getAccount(),user.getPwd(),user.getUserId());
	}
	
	/**
	 * ��Idɾ���û���Ϣ
	 * @param id
	 * @return
	 */
	public int delete(String id){
		String sql = "delete from users where userId=?";
		
		//ִ��SQL���
		return this.executeUpdate(sql, id);
	}
	
	/**
	 * ��ѯ�����û��б�
	 * @return
	 */
	public List<User> getAll(){
		String sql = "select * from users";
		
		//ִ��SQL���
		return this.executeQuery(User.class, sql);
	}
	
	/**
	 * ����Id��ѯָ���û�����Ϣ
	 * @param id
	 * @return
	 */
	public User getById(String id){
		String sql = "select * from users where userid=?";
		
		List<User> list = this.executeQuery(User.class, sql, id);
		return (list.size()>0) ? list.get(0) : null;
	}
	
	/**
	 * ��������ִ��ģ����ѯ
	 * @param name
	 * @return
	 */
	public List<User> getByName(String name){
		String sql = "select * from users where userName like ?";
		return this.executeQuery(User.class, sql, "%" + name + "%");
	}
}
