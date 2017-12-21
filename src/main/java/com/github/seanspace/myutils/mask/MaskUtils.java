package com.github.seanspace.myutils.mask;

import org.apache.commons.lang3.StringUtils;

/**
 * 掩码工具类
 */
public class MaskUtils {
	private static final String MOBILE_MASK = "*******";
	private static final String IDENTITYCODE_MASK = "**********";
	private static final String MASK = "*";
	private static final String BANK_PWD_MASK = "******";
	private static final String CVV_MASK = "***";

	

	/**
	 * 手机号掩码处理,保留后四位
	 * 
	 * @param cellphoneNo
	 * @return
	 */
	public static String maskMobile(String cellphoneNo) {
		if(cellphoneNo==null || cellphoneNo.trim().length()!=11){
			return cellphoneNo;
		}
		return new StringBuilder().append(cellphoneNo.substring(0,3))
				.append("****").append(cellphoneNo
						.substring(cellphoneNo.length() - 4)).toString();
	}

	/**
	 * 姓名掩码处理，保留首位，其他掩码
	 * 
	 * @param userName
	 * @return
	 */
	public static String maskName(String userName) {
		if (userName == null || userName.length() < 2) {
			return userName;
		}
		String _name = userName.substring(0, 1);
		int len = userName.length() - 1;
		StringBuffer buf=new StringBuffer();
		buf.append(_name);
		for (int i = 0; i < len; i++) {
			buf.append(MASK);
		}
		return buf.toString();
	}

	/**
	 * 身份证号掩码处理，6-15位做掩码处理
	 * 
	 * @param idCardNo
	 * @return
	 */
	public static String maskIdCardNo(String idCardNo) {
		return maskCardNo(idCardNo);
	}

	/**
	 * 隐藏卡号信息
	 * @param cardNo
	 * @return
	 */
	private static String maskCardNo(String cardNo){
		if(cardNo==null || cardNo.trim().length()<=8){
			return cardNo;
		}
		cardNo = cardNo.trim();
		int length = cardNo.length();
		String firstFourNo = cardNo.substring(0,4);
		String lastFourNo = cardNo.substring(length-4);
		String mask = "";
		for(int i=0; i<length-8; i++){
			mask +="*";
		}
		return firstFourNo + mask +lastFourNo;
	}

	/**
	 * 银行卡号掩码处理，保留前6 后四，其他做掩码处理
	 * 
	 * @param bankCardNo
	 * @return
	 */
	public static String maskBankCardNo(String bankCardNo) {
		return maskCardNo(bankCardNo);
	}

	/**
	 * 掩码中间数据
	 * @param str
	 * @return
     */
	public static String hiddenMiddle(String str) {
		if (str == null || str.length() <= 0) {
			return str;
		}
		int len = str.length();
		if (len > 8) {

			StringBuffer slash = new StringBuffer();
			for (int i = 0; i != len - 8; i++) {
				slash.append(MASK);
			}
			return str.substring(0, 4) + slash
					+ str.substring(len - 4);
		} else if (len > 2) {
			StringBuffer slash = new StringBuffer();
			for (int i = 2; i < len; i++) {
				slash.append(MASK);
			}
			return str.substring(0, 2) + slash ;
		} else {
			return "**";
		}
	}

	/**
	 * 邮箱地址
	 * @param email
	 * @return
     */
	public static String maskEmail(String email) {
		if (email != null && email.length() > 0 && email.contains("@")) {
			String hiddenStr = "" ;
			String[] split = email.split("@");
			if (split[0] != null) {
				hiddenStr = hiddenStr + hiddenMiddle(split[0]);
			}
			hiddenStr = hiddenStr + "@" + split[1];
			return hiddenStr;
		}
		return null;
	}

	/**
	 * CVV做掩码处理
	 */
	public static String maskCvv(String cvv) {
		if (!StringUtils.isBlank(cvv)) {
			return CVV_MASK;
		}
		return cvv;
	}
	/**
	 * 支付密码做掩码处理
	 */
	public static String maskBankPwd(String bankPwd) {
		if (!StringUtils.isBlank(bankPwd)) {
			return BANK_PWD_MASK;
		}
		return bankPwd;
	}

	/**
	 * 是否手机号
	 * @param o
	 * @return
	 */
	public static boolean isMobileNo(Object o) {
		String str = String.valueOf(o);
		return str.matches("(13\\d|14[57]|15[^4,\\D]|17[678]|18\\d)\\d{8}|170[059]\\d{7}");
	}

	/**
	 * 是否银行卡号
	 * @param o
	 * @return
	 */
	public static  boolean isBankCardNo(Object o) {
		String str = String.valueOf(o);
		return str.matches("\\d{16}|\\d{19}");
	}

	public static void main(String[] args) {
		System.out.println(hiddenMiddle("12"));
	}
}
