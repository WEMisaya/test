package test;

import com.cpospas.common.util.ThreeDESUtil;

public class desEncode {
	
	public static void main(String[] args) {
		String username = "li3EzoOW11guHen+T3CpBg==";
		String password = "+H8I84Z6KxqwFZExc2FN4g==";
		String enStr = "jdbc:mysql://25.0.89.75:3307/cpospdb";
		String str = ThreeDESUtil.encryptMode(username);
		String str2 = ThreeDESUtil.encryptMode(password);
		System.out.println(new String(ThreeDESUtil.decryptMode(username)));
		System.out.println(new String(ThreeDESUtil.decryptMode(password)));
		
		String comp = "4mqTwJwwo12Hc6vJst7wbHokGSN4nlMBnUW0DIBwarRehPic0AioUg==";
		if (comp.equals(str)) {
			System.out.println(" is the one<>"+new String(ThreeDESUtil.decryptMode(comp))+"<>");
		}else
			System.out.println(" is the not one<>"+new String(ThreeDESUtil.decryptMode(comp))+"<>");

	}

}
