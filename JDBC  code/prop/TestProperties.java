package cn.hl.prop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		File file =new File("config.properties");
		//�ж��ļ��Ƿ����
		if(file.exists()){
			//ʵ����һ��Properties���͵Ķ���
			Properties prop = new Properties();
			//���������ļ�
			prop.load(new FileInputStream(file));
			//��ȡ�����ļ�
			//����keyֵ��ȡ�����ļ�
			String url = prop.getProperty("url");
			System.out.println(url);
		}
		else{
			System.out.println("�����ļ���ȡʧ��");
		}

	}

}
