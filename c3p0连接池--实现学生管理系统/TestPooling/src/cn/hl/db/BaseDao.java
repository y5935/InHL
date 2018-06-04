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
 * Dao = Data Access Object(数据访问对象)
 * @author Lens
 *
 */
public class BaseDao {
	private Connection con ;
	private PreparedStatement ps;
	private ResultSet rs;
	/**
	 * 执行非查询语句并返回受影响行数
	 * eg：insert、delete及update
	 * @param sql  待执行的Sql语句
	 * @param parameters  参数集合
	 * @return
	 */
	public int executrUpdate(String sql,Object...parameters){
		try {
			//初始化preparedStatement对象
			initStatement(sql,parameters);
			//执行sql语句
			return ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			//关闭所有对象
		close();	
		}	
	}
	/**
	 * 执行查询语句
	 * @param cls： 返回数据的类型
	 * @param sql：待执行sql语句
	 * @param parameters ：语句所需参数
	 * @return ：查询结果集
	 */
	public <T> List<T> executeQuery(Class<T> cls,String sql,Object...parameters){
		//存储T类型的对象（查询结果）
		List<T> list = new ArrayList<T>();
		try {
			//初始化PrepareStatement对象
			initStatement(sql,parameters);
			//执行查询语句
			rs = ps.executeQuery();
			//处理查询结果
			while(rs.next()){
				//实例化T类型对象
				try {
					T instance = cls.newInstance();
		     		//获取T类型所用声明字段
					Field[] fields = cls.getDeclaredFields();
					//遍历Field字段的集合
					for (Field field : fields) {
						field.setAccessible(true);
						if(field.getType()==String.class)
							field.set(instance, rs.getString(field.getName()));
						if(field.getType()==int.class||field.getType()==Integer.class)
							field.set(instance, rs.getInt(field.getName()));
						else
							field.set(instance, rs.getObject(field.getName()));
					}
					//将T类型的对象添加到List集合中
					list.add(instance);				
				} catch (InstantiationException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}finally{
			//关闭连接
			close();
		}
		
		return list;
	}
	
	/**
	 * 初始化PrepareStatement对象
	 * @param sql
	 * @param parameters
	 * @throws SQLException
	 */
	private  void initStatement(String sql, Object[] parameters) throws SQLException {
		//获取Connection连接对象
		con= DBUtil.getConnection();
		//通过Connection连接对象获取PreparedStatement对象
		ps = con.prepareStatement(sql);
		//初始化PrepareStatement对象的参数
		for (int i = 0; i < parameters.length; i++) {
			ps.setObject(i+1, parameters[i]);
		}
		
	}

	private void close() {
		//关闭resultSet对象
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
