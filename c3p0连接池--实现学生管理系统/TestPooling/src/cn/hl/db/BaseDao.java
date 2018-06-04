package cn.hl.db;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.hl.bean.Student;

/**
 * BaseDao
 * Dao = Data Access Object(���ݷ��ʶ���)
 * @author Lens
 *
 */
public class BaseDao {
	private Connection con ;
	private PreparedStatement ps;
	private ResultSet rs;
	/**
	 * ִ�зǲ�ѯ��䲢������Ӱ������
	 * eg��insert��delete��update
	 * @param sql  ��ִ�е�Sql���
	 * @param parameters  ��������
	 * @return
	 */
	public int executrUpdate(String sql,Object...parameters){
		try {
			//��ʼ��preparedStatement����
			initStatement(sql,parameters);
			//ִ��sql���
			return ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			//�ر����ж���
		close();	
		}	
	}
	/**
	 * ִ�в�ѯ���
	 * @param cls�� �������ݵ�����
	 * @param sql����ִ��sql���
	 * @param parameters ������������
	 * @return ����ѯ�����
	 */
	public <T> List<T> executeQuery(Class<T> cls,String sql,Object...parameters){
		//�洢T���͵Ķ��󣨲�ѯ�����
		List<T> list = new ArrayList<T>();
		try {
			//��ʼ��PrepareStatement����
			initStatement(sql,parameters);
			//ִ�в�ѯ���
			rs = ps.executeQuery();
			//�����ѯ���
			while(rs.next()){
				//ʵ����T���Ͷ���
				try {
					T instance = cls.newInstance();
		     		//��ȡT�������������ֶ�
					Field[] fields = cls.getDeclaredFields();
					//����Field�ֶεļ���
					for (Field field : fields) {
						field.setAccessible(true);
						if(field.getType()==String.class)
							field.set(instance, rs.getString(field.getName()));
						if(field.getType()==int.class||field.getType()==Integer.class)
							field.set(instance, rs.getInt(field.getName()));
						else
							field.set(instance, rs.getObject(field.getName()));
					}
					//��T���͵Ķ�����ӵ�List������
					list.add(instance);				
				} catch (InstantiationException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}finally{
			//�ر�����
			close();
		}
		
		return list;
	}
	
	/**
	 * ��ʼ��PrepareStatement����
	 * @param sql
	 * @param parameters
	 * @throws SQLException
	 */
	private  void initStatement(String sql, Object[] parameters) throws SQLException {
		//��ȡConnection���Ӷ���
		con= DBUtil.getConnection();
		//ͨ��Connection���Ӷ����ȡPreparedStatement����
		ps = con.prepareStatement(sql);
		//��ʼ��PrepareStatement����Ĳ���
		for (int i = 0; i < parameters.length; i++) {
			ps.setObject(i+1, parameters[i]);
		}
		
	}

	private void close() {
		//�ر�resultSet����
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps != null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	
}
