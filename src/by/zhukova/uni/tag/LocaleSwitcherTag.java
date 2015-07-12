package by.zhukova.uni.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class LocaleSwitcherTag extends TagSupport {
	
	@Override
	public int doStartTag() throws JspException {
		String textTag = "<div class='locale'>" +
			"<a href='controller?command=lang&loс=ru_RU'>RU</a> | "
			+ "<a href='controller?command=lang&loc=en_US'>EN</a></div>";
		
		try {
			JspWriter out = pageContext.getOut();
			out.write(textTag); 
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
