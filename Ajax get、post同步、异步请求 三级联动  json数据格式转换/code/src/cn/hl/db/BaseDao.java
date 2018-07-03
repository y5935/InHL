package cn.hl.db;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BaseDao {
	//声明连接对象
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	/**
	 * 执行非查询语句，eg:insert、delete及update
	 * @param sql
	 * @param params
	 * @return
	 */
	public int executeUpdate(String sql, Object...params){
		try {
			//1、初始化连接对象
			this.initStatement(sql, params);
			
			//执行SQL语句
			return ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		finally{
			close();
		}
	}
	
	/**
	 * 执行查询语句
	 * @param cls	：实体类Class类型的实例
	 * @param sql	：待执行SQL语句
	 * @param params：语句参数
	 * @return		：查询结果集
	 */
	public <T> List<T> executeQuery(Class<T> cls,String sql, Object...params){
		//定义集合对象存储查询结果
		List<T> list = new ArrayList<T>();
		
		try {
			//1、初始化连接对象
			this.initStatement(sql, params);
			
			//2、执行SQL语句
			rs = ps.executeQuery();
			
			//3、将查询结果存储到集合对象中
			while(rs.next()){
				//通过cls对象实例化一个T类型的对象
				T instance = cls.newInstance();
				//读取T类型对象的所有成员字段
				Field[] fields = cls.getDeclaredFields();
				
				//对Bean对象的所有字段进行遍历
				//通过成员字段读取rs中的数据
				for(Field field : fields){
					//设置可以直接访问字段
					field.setAccessible(true);
					//根据字段类型为字段赋值
					if(field.getType() == String.class)
						field.set(instance, rs.getString(field.getName()));
					else if(field.getType() == int.class || field.getType()== Integer.class)
						field.setInt(instance, rs.getInt(field.getName()));
					else
						field.set(instance, rs.getObject(field.getName()));
				}
				
				//将赋值后的对象添加到list集合中
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
	 * 关闭所有数据库连接对象
	 */
	private void close(){
		//关闭ResultSet对象
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//关闭PreparedStatement对象
		if(ps != null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//关闭connection对象
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
	 * 初始化PreparedStatement对象
	 * @param sql			：待执行SQL语句
	 * @param params		：命令参数集合
	 * @throws SQLException
	 */
	private void initStatement(String sql, Object...params) throws SQLException{
		//获取连接对象
		conn = DbHelper.getConnection();
		
		//通过conn对象获取PreparedStatement对象
		ps = conn.prepareStatement(sql);
		
		//设置命令参数
		for(int i = 0;i<params.length;i++){
			ps.setObject((i+1), params[i]);
		}
	}
}
