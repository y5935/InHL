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
		//����һ��Properties���͵Ķ������ڶ�ȡProperties�����ļ���
		Properties properties = new  Properties();
		//���������ļ�
		InputStream is = TestDbcp.class.getResourceAsStream("/dbcp.properties");
		properties.load(is);
		
		//BasicDataSourceFacotry :�����࣬�ṩ���ڻ�ȡconnection�������ط���
		//û��ʵ�����塣BasicDataSourceFactory��һ�������࣬һ������¹�����ķ������Ǿ�̬
		//BasicDataSourceFactory fac = new BasicDataSourceFactory();
		
		//ͨ��Properties��ȡ���ӳ��������Ϣ
		//DataSource	������Դ��ʵ�����������ӳض��󣩣�ͨ��DataSource���Ի�ȡ��Connection����
		DataSource ds = BasicDataSourceFactory.createDataSource(properties);
		
		//Connection	�����ݿ����Ӷ���
		//org.apache.commons.dbcp.PoolableConnection
		Connection con = ds.getConnection();
			
		//close()		���ر����Ӷ������ӳ�״̬�£�close()������������Ĺر����ӡ�����ֻ�ǰ����Ӷ���黹�����ӳ�
		con.close();
	}
}
