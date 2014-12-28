package org.llh.ssl.common;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 分页标签处理类
 */
public class SecretTag extends TagSupport {

	private static final long serialVersionUID = 1236308696888715271L;

	private static final String TYPE_TEL = "tel";
	private static final String TYPE_MAIL = "mail";
	private static final String TYPE_IDCARD = "idcard";
	private static final String TYPE_BKCARD = "bkcard";
	
	private String value;
	
	private String type;
	
	public int doStartTag() throws JspException {

		String regex = "";
		
		if(null == type && "".equals(type)) {
			
			regex = secretStr(regex, 3, 3);
		
		}else if(TYPE_TEL.equals(type)) {
			
			regex = secretStr(regex, 3, 3);
			
		}else if(TYPE_MAIL.equals(type)) {
			
			String[] mail = regex.split("@");
			regex = secretStr(mail[0], 1, 3) + "@" + mail[1];
			
		}else if(TYPE_IDCARD.equals(type)) {
			
			regex = secretStr(regex, 3, 3);
			
		}else if(TYPE_BKCARD.equals(type)) {
			
			regex = secretStr(regex, 3, 3);
			
		}else {
			
			regex = secretStr(regex, 3, 3);
			
		}
		
		// 把生成的HTML输出到响应中
		try {
			pageContext.getOut().println(regex);
		} catch (IOException e) {
			throw new JspException(e);
		}
		return SKIP_BODY; // 本标签主体为空,所以直接跳过主体
	}
	
	private static String secretStr(String regex, int toffset, int ooffset) {
		
		int len = regex.length();
		if(len <= toffset + ooffset)
			return regex;
		int n = len - toffset - ooffset;
        char[] cs = regex.toCharArray();
        
        for (int i = 0; i < n; i++){
            cs[toffset + i] = '*';
        }
        return String.valueOf(cs);
    }
	
	public static void main(String[] args) {
		String regex = "suncallh@163.com";
		String[] mail = regex.split("@");
		regex = secretStr(mail[0], 1, 3) + "@" + mail[1];
		
		System.out.println(regex);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}