package cn.hl.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密算法 密码可以分为：单向可逆和单向不可逆（MD5就是单向不可逆）
 * 又可以分为：对称加密（加密、解密双方使用一样的密钥，速度快，适用于小内容加密）和非对称加密
 * 
 * 
 * @author Lens
 * 
 */
public class MD5 {
	public static String MD5(String key) {
		String result = "";
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			byte[] btInput = key.getBytes();
			// 获得MD5摘要算法的MessageDigest对象
			MessageDigest mdInst;

			mdInst = MessageDigest.getInstance("MD5");

			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//返回加密字符串
		return result;
	}

	public static void main(String[] args) {
		// 待加密字符串
		String str = MD5("liu");
		System.out.println(str);
	}
}
