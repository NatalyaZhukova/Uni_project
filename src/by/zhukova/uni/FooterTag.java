package by.zhukova.uni;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;


public class FooterTag extends TagSupport {
	
	@Override
	public int doStartTag() throws JspException {
		
		String footer = "<hr/> (c)Zhukova";
		
		JspWriter out = pageContext.getOut();
		try {
			out.write(footer);
		} catch (IOException e) {
			throw new JspException(e.getMessage());
		}
		return SKIP_BODY;
		
	}
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

}
