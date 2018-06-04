package cn.hl.db;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * �ṩconnection
 * ʹ��c3p0����Դ
 * @author Lens
 *
 */
public class DBUtil {
	//����һ��ComboPooledDataSource����
	//��������:����Ӧ�ó��������ڼ�
	
	private static ComboPooledDataSource dataSource = null;
	/**
	 * ��ȡһ��Connection����ʵ��
	 * ˫�ؼ�飨double check��----һ�����������һ�����������
	 * �ŵ㣺���� ����û������Ĵ�������
	 * ȱ�㣺Ч���½� 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		//�ж�DataSource�����Ƿ�Ϊ��
		if(dataSource == null){
			//ʹ�������ƴ����ִ�� 
			synchronized(DBUtil.class){
				//�ٴ��ж�DataSource����
				if(dataSource == null)
					dataSource = new ComboPooledDataSource();
			}
		}
		//����һ��Connection����
		
		return dataSource.getConnection();
		
	}
	
}
