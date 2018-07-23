package cn.hl.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5�����㷨 ������Է�Ϊ���������͵��򲻿��棨MD5���ǵ��򲻿��棩
 * �ֿ��Է�Ϊ���ԳƼ��ܣ����ܡ�����˫��ʹ��һ������Կ���ٶȿ죬������С���ݼ��ܣ��ͷǶԳƼ���
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
			// ���MD5ժҪ�㷨��MessageDigest����
			MessageDigest mdInst;

			mdInst = MessageDigest.getInstance("MD5");

			// ʹ��ָ�����ֽڸ���ժҪ
			mdInst.update(btInput);
			// �������
			byte[] md = mdInst.digest();
			// ������ת����ʮ�����Ƶ��ַ�����ʽ
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
		//���ؼ����ַ���
		return result;
	}

	public static void main(String[] args) {
		// �������ַ���
		String str = MD5("liu");
		System.out.println(str);
	}
}
