package Email;
/**
 * ����������ʽ��֤�����ʽ�Ƿ���ȷ
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailDemo {
	public static boolean cheakEmail(String email) {
		boolean flag = false;
		String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-z0-9A-Z]{2,}$";
		Pattern regex = Pattern.compile(check);
		Matcher matcher = regex.matcher(email);
		flag = matcher.matches();
		return flag;
	}

	
	public static void main(String[] args) {
		System.out.println(cheakEmail("654605797@qq.com"));
	}
}
