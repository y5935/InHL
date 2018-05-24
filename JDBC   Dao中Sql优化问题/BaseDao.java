package cn.hl.db;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Dao = Data Access Object(数据访问对象)
 * 	提供用于数据操作的相关方法
 * @author X230
 *
 */
public class BaseDao extends DBUtil{
	/**
	 * 执行非查询语句.
	 * eg:insert、delete及update
	 * @param sql	：待执行Sql语句
	 * @return		：受影响行数
	 * @throws SQLException 
	 */
	public int executeUpdate(String sql) throws SQLException{
		//1、获取数据库连接对象
		Connection con = this.getConnection();
		
		//2、获取Statment对象
		Statement smt = con.createStatement();
		
		//3、执行Sql语句
		int result = smt.executeUpdate(sql);
		//4、关闭连接对象
		con.close();
		
		//5、返回受影响行数
		return result;
	}
	
	/**
	 * 执行查询语句并返回查询结果集字符串
	 * @param sql
	 * @return
	 * @throws SQLException
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public <T> List<T> executeQuery(Class<T> cls,String sql) throws SQLException, InstantiationException, IllegalAccessException{
		List<T> list = new ArrayList<T>();
		//1、获取数据库连接对象
		Connection con = this.getConnection();
		 
		//2、获取Statement对象
		Statement smt = con.createStatement();
		
		//3、执行Sql语句
		ResultSet rs = smt.executeQuery(sql);
		
		//4、处理查询结果
		while(rs.next()){
			//读取一行记录
			//1)、通过反射实例化T类型的对象
			T instance = cls.newInstance();
			
			//2)、获取所有T的成员字段
			Field[] fields = cls.getDeclaredFields();
			
			//3)、为所有T的成员字段进行赋值
			for(Field field : fields){
				field.setAccessible(true);
				//判断字段的类型，根据字段的类型调用rs的相关方法
				if(field.getType() == String.class)
					field.set(instance, rs.getString(field.getName()));
				else if(field.getType() == int.class || field.getType() == Integer.class)
					field.set(instance, rs.getInt(field.getName()));
				else if(field.getType() == boolean.class || field.getType() == Boolean.class)
					field.set(instance, rs.getBoolean(field.getName()));
				else
					field.set(instance, rs.getObject(field.getName()));
			}
						
			//记录添加到list集合中
			list.add(instance);
		}
		
		//5、关闭连接
		con.close();
		
		//6、返回查询结果
		return list;
	}
}
