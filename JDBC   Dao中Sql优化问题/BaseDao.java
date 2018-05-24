package cn.hl.db;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Dao = Data Access Object(���ݷ��ʶ���)
 * 	�ṩ�������ݲ�������ط���
 * @author X230
 *
 */
public class BaseDao extends DBUtil{
	/**
	 * ִ�зǲ�ѯ���.
	 * eg:insert��delete��update
	 * @param sql	����ִ��Sql���
	 * @return		����Ӱ������
	 * @throws SQLException 
	 */
	public int executeUpdate(String sql) throws SQLException{
		//1����ȡ���ݿ����Ӷ���
		Connection con = this.getConnection();
		
		//2����ȡStatment����
		Statement smt = con.createStatement();
		
		//3��ִ��Sql���
		int result = smt.executeUpdate(sql);
		//4���ر����Ӷ���
		con.close();
		
		//5��������Ӱ������
		return result;
	}
	
	/**
	 * ִ�в�ѯ��䲢���ز�ѯ������ַ���
	 * @param sql
	 * @return
	 * @throws SQLException
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public <T> List<T> executeQuery(Class<T> cls,String sql) throws SQLException, InstantiationException, IllegalAccessException{
		List<T> list = new ArrayList<T>();
		//1����ȡ���ݿ����Ӷ���
		Connection con = this.getConnection();
		 
		//2����ȡStatement����
		Statement smt = con.createStatement();
		
		//3��ִ��Sql���
		ResultSet rs = smt.executeQuery(sql);
		
		//4�������ѯ���
		while(rs.next()){
			//��ȡһ�м�¼
			//1)��ͨ������ʵ����T���͵Ķ���
			T instance = cls.newInstance();
			
			//2)����ȡ����T�ĳ�Ա�ֶ�
			Field[] fields = cls.getDeclaredFields();
			
			//3)��Ϊ����T�ĳ�Ա�ֶν��и�ֵ
			for(Field field : fields){
				field.setAccessible(true);
				//�ж��ֶε����ͣ������ֶε����͵���rs����ط���
				if(field.getType() == String.class)
					field.set(instance, rs.getString(field.getName()));
				else if(field.getType() == int.class || field.getType() == Integer.class)
					field.set(instance, rs.getInt(field.getName()));
				else if(field.getType() == boolean.class || field.getType() == Boolean.class)
					field.set(instance, rs.getBoolean(field.getName()));
				else
					field.set(instance, rs.getObject(field.getName()));
			}
						
			//��¼��ӵ�list������
			list.add(instance);
		}
		
		//5���ر�����
		con.close();
		
		//6�����ز�ѯ���
		return list;
	}
}
