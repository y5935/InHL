package cn.hl.pooling.dbcp;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

public class TestDbcp {
	@Test
	public void testDbcp() throws Exception{
		//创建一个Properties类型的对象（用于读取Properties配置文件）
		Properties properties = new  Properties();
		//加载配置文件
		InputStream is = TestDbcp.class.getResourceAsStream("/dbcp.properties");
		properties.load(is);
		
		//BasicDataSourceFacotry :工厂类，提供用于获取connection对象的相关方法
		//没有实际意义。BasicDataSourceFactory是一个工厂类，一般情况下工厂类的方法都是静态
		//BasicDataSourceFactory fac = new BasicDataSourceFactory();
		
		//通过Properties获取连接池所需的信息
		//DataSource	：数据源（实际他就是连接池对象），通过DataSource可以获取到Connection对象
		DataSource ds = BasicDataSourceFactory.createDataSource(properties);
		
		//Connection	：数据库连接对象
		//org.apache.commons.dbcp.PoolableConnection
		Connection con = ds.getConnection();
			
		//close()		：关闭连接对象。连接池状态下，close()方法并不是真的关闭连接。这里只是把连接对象归还给连接池
		con.close();
	}
}
