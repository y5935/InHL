package cn.hl.db;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BaseDao {
	//�������Ӷ���
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	/**
	 * ִ�зǲ�ѯ��䣬eg:insert��delete��update
	 * @param sql
	 * @param params
	 * @return
	 */
	public int executeUpdate(String sql, Object...params){
		try {
			//1����ʼ�����Ӷ���
			this.initStatement(sql, params);
			
			//ִ��SQL���
			return ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		finally{
			close();
		}
	}
	
	/**
	 * ִ�в�ѯ���
	 * @param cls	��ʵ����Class���͵�ʵ��
	 * @param sql	����ִ��SQL���
	 * @param params��������
	 * @return		����ѯ���
	 */
	public <T> List<T> executeQuery(Class<T> cls,String sql, Object...params){
		//���弯�϶���洢��ѯ���
		List<T> list = new ArrayList<T>();
		
		try {
			//1����ʼ�����Ӷ���
			this.initStatement(sql, params);
			
			//2��ִ��SQL���
			rs = ps.executeQuery();
			
			//3������ѯ���洢�����϶�����
			while(rs.next()){
				//ͨ��cls����ʵ��һ��T���͵Ķ���
				T instance = cls.newInstance();
				//��ȡT���Ͷ�������г�Ա�ֶ�
				Field[] fields = cls.getDeclaredFields();
				
				//��Bean����������ֶν��б���
				//ͨ���Ա�ֶζ�ȡrs�е����
				for(Field field : fields){
					//���ÿ���ֱ�ӷ����ֶ�
					field.setAccessible(true);
					//����ֶ�����Ϊ�ֶθ�ֵ
					if(field.getType() == String.class)
						field.set(instance, rs.getString(field.getName()));
					else if(field.getType() == int.class || field.getType()== Integer.class)
						field.setInt(instance, rs.getInt(field.getName()));
					else if(field.getType() == List.class){
						continue;
					}
					else
						field.set(instance, rs.getObject(field.getName()));
				}
				
				//����ֵ��Ķ�����ӵ�list������
				list.add(instance);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			close();
		}
		
		return list;
	}
	
	/**
	 * ��ѯָ����ݱ��м�¼������
	 * @param tableName	������
	 * @return			����¼����
	 */
	public int getRows(String tableName){
		return getRows(tableName,"");
	}
	
	/**
	 * ��ѯָ����ݱ��м�¼������
	 * @param tableName	������
	 * @param filter	����ѯ����������Ҫʹ��where�Ӿ䣩
	 * @return			����¼����
	 */
	public int getRows(String tableName, String filter){
		//��дSQL���
		String sql = "select count(*) as total from " + tableName;
		
		//�ж��Ƿ���в�ѯ����
		if(filter != null && !"".equals(filter.trim())){
			sql = sql + "where " + filter;
		}
		
		try {
			//��ʼ�����Ӷ���
			this.initStatement(sql);
			
			//ִ��SQL���
			rs = ps.executeQuery();
			
			if(rs.next())
				return rs.getInt("total");
			else
				return 0;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		finally{
			close();
		}
	}
	
	/**
	 * �ر�������ݿ����Ӷ���
	 */
	private void close(){
		//�ر�ResultSet����
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//�ر�PreparedStatement����
		if(ps != null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//�ر�connection����
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * ��ʼ��PreparedStatement����
	 * @param sql			����ִ��SQL���
	 * @param params		����������
	 * @throws SQLException
	 */
	private void initStatement(String sql, Object...params) throws SQLException{
		//��ȡ���Ӷ���
		conn = DbHelper.getConnection();
		
		//ͨ��conn�����ȡPreparedStatement����
		ps = conn.prepareStatement(sql);
		
		
		//�����������
		for(int i = 0;i<params.length;i++){
			ps.setObject((i+1), params[i]);
		}
	}
}
