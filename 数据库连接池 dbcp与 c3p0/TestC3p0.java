package cn.hl.pooling.c3p0;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestC3p0 {

	public static void main(String[] args) throws SQLException {
		//��ȡComboPooledDataSource����
		//ͨ��ComboPooledDataSource������Ի�ȡ������Դ����---���ӳ���
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		//ͨ��ComboPooledDataSolurce�����getConnection()���Ի�ȡ�����Ӷ���
		//Connection��C3p0�б�ת�����˴������
		Connection con = dataSource.getConnection();
		System.out.println(con);
		//�ر����Ӷ���
		con.close();

	}

}
