package cn.hl.db;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 提供connection
 * 使用c3p0数据源
 * @author Lens
 *
 */
public class DBUtil {
	//定义一个ComboPooledDataSource对象
	//声明周期:整个应用程序运行期间
	
	private static ComboPooledDataSource dataSource = null;
	/**
	 * 获取一个Connection对象实例
	 * 双重检查（double check）----一个在锁的里边一个在锁的外边
	 * 优点：可以 避免没有意义的创建过程
	 * 缺点：效率下降 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		//判断DataSource对象是否为空
		if(dataSource == null){
			//使用锁控制代码的执行 
			synchronized(DBUtil.class){
				//再次判断DataSource对象
				if(dataSource == null)
					dataSource = new ComboPooledDataSource();
			}
		}
		//返回一个Connection对象
		
		return dataSource.getConnection();
		
	}
	
}
