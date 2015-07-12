package by.zhukova.uni.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class FooterTag extends TagSupport {
	
	@Override
	public int doStartTag() throws JspException {

	String footerText = "<div class='footer'><hr/>(c) Zhukova, 2015</div>";
	
	try {
		JspWriter out = pageContext.getOut();
		out.write(footerText); 
		}
	catch (IOException e) {
		throw new JspException(e.getMessage());
	}
	return SKIP_BODY;
	}
	
	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

}
