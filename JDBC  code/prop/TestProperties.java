package cn.hl.prop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		File file =new File("config.properties");
		//判断文件是否存在
		if(file.exists()){
			//实例化一个Properties类型的对象
			Properties prop = new Properties();
			//加载配置文件
			prop.load(new FileInputStream(file));
			//读取配置文件
			//按照key值读取配置文件
			String url = prop.getProperty("url");
			System.out.println(url);
		}
		else{
			System.out.println("配置文件读取失败");
		}

	}

}
