package cn.hl.dao.impl;

import java.util.List;

import cn.hl.bean.User;
import cn.hl.dao.UserDao;
import cn.hl.db.BaseDao;

/**
 * ����������ݣ�
 * ɾ����Idɾ�� ���ݣ�
 * �ģ���Id�޸����ݣ�
 * �飨��ѯ�������ݡ���id��ѯ��һ���ݡ���������ѯ��
 * 
 * @author Lens
 *
 */
public class UserDaoImpl extends BaseDao implements UserDao {
	/**
	 * ����û���Ϣ
	 * @param user
	 * @return
	 */
	public int add(User user){
		return 0;
		
	}
	/**
	 * �޸��û���Ϣ
	 * @param user
	 * @return
	 */
	public int update(User user){
		return 0;
		
	}
	
	/**
	 * ɾ���û���Ϣ
	 * @param id
	 * @return
	 */
	public int delete(int id){
		return id;
		
	}
	 
	/**
	 * ʵ���û���¼��֤
	 * �����˺ź������ѯ�û���Ϣ 
	 * @param account
	 * @param pwd
	 * @return
	 */
	public User getByAccount(String account,String pwd){
		//��дSql���
		String sql = "select* from users where account=? and pwd =?";
		//ִ�в�ѯ
		List<User> list = this.executeQuery(User.class, sql, account,pwd);
		//�жϲ�ѯ��������������Ԫ�ض���0����ʾ��֤�ɹ���
	/*	if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}*/
		return (list.size()>0) ? list.get(0) : null;
	}
	
	
	
}
